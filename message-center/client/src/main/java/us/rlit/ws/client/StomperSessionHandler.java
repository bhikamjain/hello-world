package us.rlit.ws.client;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.messaging.simp.stomp.StompCommand;
import org.springframework.messaging.simp.stomp.StompHeaders;
import org.springframework.messaging.simp.stomp.StompSession;
import org.springframework.messaging.simp.stomp.StompSessionHandlerAdapter;

import java.util.Date;

public class StomperSessionHandler extends StompSessionHandlerAdapter {

    private Logger logger = LogManager.getLogger(StomperSessionHandler.class);

    @Override
    public void afterConnected(StompSession session, StompHeaders connectedHeaders) {
        logger.info("New session established : " + session.getSessionId());
        session.subscribe("/trade", this);
        logger.info("Subscribed to /trade");
        //session.send("/app/send/trade", getSampleMessage());
        session.send("/app/send/trade", getMessage());
        logger.info("us.rlit.ws.client.Message sent to websocket server");
    }

    @Override
    public void handleException(StompSession session, StompCommand command, StompHeaders headers, byte[] payload, Throwable exception) {
        logger.error("Got an exception", exception);
    }



    @Override
    public void handleFrame(StompHeaders headers, Object payload) {
        logger.info("Received : " + payload );

//        Message msg = (Message) payload;
//        logger.info("Received : " + msg.getText() + " from : " + msg.getFrom());
    }

    /**
     * A sample message instance.
     * @return instance of <code>us.rlit.ws.client.Message</code>
     */
    private Trade getSampleTrade() {
        Trade msg = new Trade();
        msg.setTicker("ABC");
        msg.setPrice(100);
        msg.setQuantity(100);
        msg.setTradeTime(new Date());
        return msg;
    }

    private Trade getMessage() {
        return getSampleTrade();
    }
    
}