package vn.edu.iuh.fit.services;

import jakarta.jms.JMSException;
import jakarta.jms.Message;
import jakarta.jms.Session;
import jakarta.jms.TextMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

@Component
public class TestMessageSender {

    @Autowired
    private JmsTemplate jmsTemplate;

    public void sendTestMessage() {
        jmsTemplate.send("order_products", new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                String jsonMessage = "{ \"customer_id\": \"1\", \"product_name\": \"Test Product\", \"quantity\": \"10\", \"status\": \"NEW\" }";
                TextMessage message = session.createTextMessage(jsonMessage);
                return message;
            }
        });
    }
}