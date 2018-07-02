package pl.edu.pjwstk.tpr.jaxws.delayed;

import pl.edu.pjwstk.tpr.jaxws.ports.TprException;
import pl.edu.pjwstk.tpr.jaxws.ports.WebServiceBase;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public class SampleDelayed extends WebServiceBase {

    private static final int DELAY = 10000;

    @WebMethod
    public String replyDelayed(String request) throws TprException {
        try {
            Thread.sleep(DELAY);
            String response = "(delayed) Hello, " + request;
            return response;
        } catch (InterruptedException ex) {
            throw new TprException("error occurred", ex);
        }
    }
}