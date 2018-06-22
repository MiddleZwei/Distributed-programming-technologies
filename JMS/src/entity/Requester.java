package entity;

import exceptions.ConnectionException;
import request.ArithmeticRequest;
import request.ArithmeticRequestType;
import request.IRequest;
import request.RandomRequest;
import response.IResponse;

import javax.jms.*;
import java.math.BigDecimal;
import java.util.Random;

public class Requester extends Member {

    private static int id_counter = 0;
    private static final String NAME_PREFIX = "REQUESTER-";

    @Override
    public void run() {
        Connection connection = null;
        try {
            connection = getConnectionFactory().createConnection();
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            MessageProducer requestMessageProducer = session.createProducer(getRequestQueue());

            Destination resultQueue = session.createQueue(name);
            MessageConsumer responseMessageConsumer = session.createConsumer(resultQueue);

            connection.start();
            for (int i = 0; i < 3; i++) {
                IRequest requestObj = produceRequest();
                logger.info("request PREPARED: " + requestObj);
                sendRequest(session, requestObj, requestMessageProducer);
                logger.info("request PUT into destination");
                IResponse responseObj = receiveResponse(responseMessageConsumer);
                processResponse(responseObj);
            }
        } catch (JMSException e) {
            e.printStackTrace();
            throw new ConnectionException(e);
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (JMSException e) {
                    logger.fatal(e);
                    throw new ConnectionException(e);
                }
            }
        }
    }

    private void processResponse(IResponse responseObj) {
        logger.info("response RECEIVED: " + responseObj);
    }

    private IRequest produceRequest() {
        Random random = new Random();
        if (random.nextInt(2) == 0) {
            return new RandomRequest(name);
        } else {
            BigDecimal p1 = new BigDecimal(random.nextInt(1000));
            BigDecimal p2 = new BigDecimal(random.nextInt(1000));
            ArithmeticRequestType reqType = ArithmeticRequestType.values()[random.nextInt(ArithmeticRequestType.values().length)];
            return new ArithmeticRequest(p1, p2, reqType, name);
        }
    }

    private void sendRequest(Session session, IRequest requestObj, MessageProducer messageProducer) throws JMSException {
        Message requestMessage = session.createObjectMessage(requestObj);
        messageProducer.send(requestMessage);
    }

    private IResponse receiveResponse(MessageConsumer messageConsumer) throws JMSException {
        return (IResponse) ((ObjectMessage) messageConsumer.receive()).getObject();
    }

    @Override
    protected String getPrefix() {
        return NAME_PREFIX;
    }

    @Override
    protected int createId() {
        return ++id_counter;
    }
}
