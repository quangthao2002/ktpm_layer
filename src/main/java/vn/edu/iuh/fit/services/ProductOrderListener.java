package vn.edu.iuh.fit.services;

import com.google.gson.Gson;
import jakarta.jms.JMSException;
import jakarta.jms.Message;
import jakarta.jms.TextMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;
import vn.edu.iuh.fit.models.Product;
import vn.edu.iuh.fit.repositorys.ProductOrderRepository;
import vn.edu.iuh.fit.repositorys.ProductRepository;
import vn.edu.iuh.fit.services.impl.OrderService;

import java.util.Map;


@Component
public class ProductOrderListener {


    @Autowired
    private ProductOrderRepository productOrderRepository;

    @Autowired
    private ProductRepository productRepositor;

    @Autowired
    private OrderService orderService  ;

    @Autowired
    private EmailService emailService;


    @JmsListener(destination = "order_products")
    public void receiveMessage(final Message jsonMessage) throws JMSException {
        String messageData = null;
        if(jsonMessage instanceof TextMessage) {
            TextMessage textMessage = (TextMessage)jsonMessage;
            messageData = textMessage.getText();
            Map<String, String> orderData = new Gson().fromJson(messageData, Map.class);
            String customerId = orderData.get("customer_id");
            String productName = orderData.get("product_name");
            long quantity = Long.parseLong(orderData.get("quantity"));
            String status = orderData.get("status");

            Product product = productRepositor.findByName(productName);
            if(product != null && product.getQuantityInStock() >= quantity) {
                // make order
                orderService.createOrder(customerId, product, quantity, status);
                // send email
                emailService.sendSimpleMessage(customerId, "Order Confirmation", "Your order has been confirmed");
                // ...
            } else {
                // reject order
                // send email
                emailService.sendSimpleMessage(customerId, "Order Rejected", "Your order has been rejected");
                // ...
            }
        }
    }


}
