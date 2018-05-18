package listeners;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebListener
public class RequestEventListener implements ServletRequestListener {
    private final static Logger logger;

    static {
        logger = Logger.getLogger("ServerLogger");
        logger.setLevel(Level.FINE);
    }
    public void requestDestroyed(ServletRequestEvent event) {
        logger.severe("Request destroyed!");
    }

    public void requestInitialized(ServletRequestEvent event) {
        logger.severe("Request initialised!");

    }
}
