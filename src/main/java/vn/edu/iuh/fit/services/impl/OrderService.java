package vn.edu.iuh.fit.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.models.Product;
import vn.edu.iuh.fit.models.ProductOrder;
import vn.edu.iuh.fit.repositorys.ProductOrderRepository;

@Service
public class OrderService {

    @Autowired
    private ProductOrderRepository productOrderRepository;

    public void createOrder(String customerId, Product product, long quantity, String status) {
        ProductOrder order = new ProductOrder(customerId, product, quantity, status);
        productOrderRepository.save(order);
    }

}
