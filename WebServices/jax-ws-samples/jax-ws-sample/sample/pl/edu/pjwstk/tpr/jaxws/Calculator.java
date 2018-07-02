package pl.edu.pjwstk.tpr.jaxws;

import pl.edu.pjwstk.tpr.jaxws.ports.WebServiceBase;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public class Calculator extends WebServiceBase {

    @WebMethod
    public int add(int component1, int component2) {
        int sum = component1 + component2;
        return sum;
    }

    @WebMethod
    public int subtract(int minuend, int subtrahend) {
        int difference = minuend - subtrahend;
        return difference;
    }
}