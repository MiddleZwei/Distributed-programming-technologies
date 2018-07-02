package pl.edu.pjwstk.tpr.jaxws.delayed;

import pl.edu.pjwstk.tpr.jaxws.ports.TprException;
import pl.edu.pjwstk.tpr.jaxws.ports.WebServiceBase;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public class CalculatorDelayed extends WebServiceBase {

    private static final int DELAY = 10000;

    @WebMethod
    public int addDelayed(int component1, int component2) throws TprException {
        sleep(DELAY);
        int sum = component1 + component2;
        return sum;
    }

    @WebMethod
    public int subtractDelayed(int minuend, int subtrahend) throws TprException {
        sleep(DELAY);
        int difference = minuend - subtrahend;
        return difference;
    }
}