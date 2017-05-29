package ru.tsystems.js20.myshkovetcv.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.jms.ConnectionFactory;
import javax.jms.ObjectMessage;

@Component
public class JmsService {

    @Resource(mappedName = "java:/ConnectionFactory")
    private ConnectionFactory jmsConnectionFactory;

    @Autowired
    private JmsTemplate jmsTemplate;

    Logger logger = LoggerFactory.getLogger(getClass());

    public void sendMessage(String msg) {
        logger.debug("Setting connection");
        jmsTemplate.setConnectionFactory(jmsConnectionFactory);
        jmsTemplate.send(session -> {
            ObjectMessage objectMessage = session.createObjectMessage(msg);
            logger.debug("Sending message: {}", msg);
            return objectMessage;
        });
    }
}
