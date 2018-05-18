package listeners;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebListener
public class ContextListener implements ServletContextListener {
    private final static Logger logger;

    static {
        logger = Logger.getLogger("ServerLogger");
        logger.setLevel(Level.FINE);
    }
    public void contextInitialized(ServletContextEvent event) {
        //do on application init
        logger.fine("Context created!");
    }

    public void contextDestroyed(ServletContextEvent event) {
        //do on application destroy
        logger.fine("Context destroyed!");
    }
}
