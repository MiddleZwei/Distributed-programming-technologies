import org.apache.activemq.ActiveMQConnectionFactory;
import request.ArithmeticRequest;
import request.IRequest;
import request.RandomRequest;
import response.ArithmeticResponse;
import response.RandomResponse;

import javax.jms.*;

public class App {

    public static void main(String[] args) throws Exception {

        String generateTask = "generate";
        String operationTask = "add";
        thread(new Producer(generateTask), false);
        thread(new Producer(generateTask), false);
        thread(new Producer(operationTask), false);
        thread(new Consumer(), false);
        thread(new Consumer(), false);
        thread(new Consumer(), false);
        Thread.sleep(1000);
        thread(new Producer(generateTask), false);
        thread(new Producer(generateTask), false);
        thread(new Producer(operationTask), false);
        thread(new Consumer(), false);
        thread(new Consumer(), false);
        thread(new Consumer(), false);
        Thread.sleep(1000);
        thread(new Producer(generateTask), false);
        thread(new Producer(generateTask), false);
        thread(new Producer(operationTask), false);
        thread(new Consumer(), false);
        thread(new Consumer(), false);
        thread(new Consumer(), false);
        Thread.sleep(1000);
    }

    public static void thread(Runnable runnable, boolean daemon) {
        Thread brokerThread = new Thread(runnable);
        brokerThread.setDaemon(daemon);
        brokerThread.start();
    }

    public static class Producer implements Runnable {
        private String operation;

        public Producer(String operation) {
            this.operation = operation;
        }

        public void run() {
            try {
                // Create a ConnectionFactory
                ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory("vm://localhost");

                // Create a Connection
                Connection connection = connectionFactory.createConnection();
                connection.start();

                // Create a Session
                Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

                // Create the destination (Topic or Queue)
                Destination destination = session.createQueue("TEST.FOO");

                // Create a MessageProducer from the Session to the Topic or Queue
                MessageProducer producer = session.createProducer(destination);
                producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);

                IRequest request;
                ObjectMessage message;
                if (operation.equals("generate")){
                    request = new RandomRequest(operation);
                    message = session.createObjectMessage(request);
                }
                else{
                    double a = 1.0;
                    double b = 2.0;
                    request = new ArithmeticRequest(operation, a, b);
                    message = session.createObjectMessage(request);
                }

                System.out.println("Sent message: "+ message.hashCode() + " : " + Thread.currentThread().getName());
                producer.send(message);

                // Clean up
                session.close();
                connection.close();
            }
            catch (Exception e) {
                System.out.println("Caught: " + e);
                e.printStackTrace();
            }
        }
    }

    public static class Consumer implements Runnable, ExceptionListener {
        public void run() {
            try {

                // Create a ConnectionFactory
                ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory("vm://localhost");

                // Create a Connection
                Connection connection = connectionFactory.createConnection();
                connection.start();

                connection.setExceptionListener(this);

                // Create a Session
                Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

                // Create the destination (Topic or Queue)
                Destination destination = session.createQueue("TEST.FOO");

                // Create a MessageConsumer from the Session to the Topic or Queue
                MessageConsumer consumer = session.createConsumer(destination);

                // Wait for a message
                Message message = consumer.receive(1000);


                if (((ObjectMessage) message).getObject() instanceof RandomRequest) {
                    ObjectMessage objectMessage = (ObjectMessage) message;
                    RandomRequest request = (RandomRequest) objectMessage.getObject();
                    RandomResponse response = new RandomResponse(request);
                    System.out.println("Random number: " + response.getMessage());
                } else if (((ObjectMessage) message).getObject() instanceof ArithmeticRequest){
                    ObjectMessage objectMessage = (ObjectMessage) message;
                    ArithmeticRequest request = (ArithmeticRequest) objectMessage.getObject();
                    ArithmeticResponse response = new ArithmeticResponse(request);
                    System.out.println("Sum: " + response.getMessage());
                }

                consumer.close();
                session.close();
                connection.close();
            } catch (Exception e) {
                System.out.println("Caught: " + e);
                e.printStackTrace();
            }
        }

        public synchronized void onException(JMSException ex) {
            System.out.println("JMS Exception occured.  Shutting down client.");
        }
    }
}