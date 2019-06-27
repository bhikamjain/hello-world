package com.ubs.am.ws.server.controllers;

import com.ubs.am.ws.server.model.Trade;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class WebSocketController {
    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(WebSocketController.class);

    private final SimpMessagingTemplate template;

    @Autowired
    WebSocketController(SimpMessagingTemplate template){
        this.template = template;
    }

    @MessageMapping("/send/trade")
    public void onReceivedMessage(Trade trade){

        // get previous posts.
        LOGGER.info("Received trade to send to /trades " + trade);
        this.template.convertAndSend("/trades",  trade);
    }

}
