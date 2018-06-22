package entity;

import exceptions.ConnectionException;
import request.IRequest;
import request.RequestProcessor;
import response.IResponse;


import javax.jms.*;
import java.util.Random;

public class Service extends Member implements MessageListener, ExceptionListener {


    // TODO:0. refactor

    private Connection connection;
    private Session session;

    private static int id_count = 0;
    private static final String NAME_PREFIX = "SERVICE-";

    public Service() {
        super();
        try {
            this.connection = getConnectionFactory().createConnection();
            this.connection.setExceptionListener(this);
            this.session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        } catch (JMSException e) {
            logger.fatal("need to start jms broker first");
            logger.fatal(e);
            throw new ConnectionException(e);
        }
    }



    @Override
    protected String getPrefix() {
        return NAME_PREFIX;
    }

    @Override
    protected int createId() {
        return id_count++;
    }

    @Override
    public void run() {
        try {
            connection.start();
            MessageConsumer requestConsumer = session.createConsumer(getRequestQueue());
            requestConsumer.setMessageListener(this);
        } catch (JMSException e) {
            throw new ConnectionException(e);
        }
    }

    @Override
    public void onMessage(Message message) {
        ObjectMessage requestMessage = (ObjectMessage) message;
        try {
            IRequest requestObj = (IRequest) requestMessage.getObject();
            logger.info("request RECEIVED: " + requestObj);
            Destination responseQueue = session.createQueue(requestObj.getSenderName());

            logger.info("starting to process the request");
            IResponse responseObj = RequestProcessor.processRequest(requestObj);
            Thread.sleep(3000 + new Random().nextInt(2000));
            logger.info("request PROCESSED");
            ObjectMessage responseMessage = session.createObjectMessage(responseObj);

            session.createProducer(responseQueue).send(responseMessage);
            logger.info("response SENT: " + responseObj);
        } catch (Exception e) {
            throw new ConnectionException(e);
        }
    }

    @Override
    public void onException(JMSException exception) {

    }
}
