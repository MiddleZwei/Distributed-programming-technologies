package exceptions;

import javax.jms.JMSException;

public class ConnectionException extends RuntimeException {

    public ConnectionException(JMSException e) {
        super(e);
    }

    public ConnectionException(Exception e) {
        super(e);
    }

    public ConnectionException(String illegal_request) {
        super(illegal_request);
    }
}
