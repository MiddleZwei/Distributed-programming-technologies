package pl.edu.pjwstk.tpr.jaxws;

import pl.edu.pjwstk.tpr.jaxws.ports.WebServiceBase;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public class Sample extends WebServiceBase {

    @WebMethod
    public String reply(String request) {
        String response = "Hello, " + request;
        return response;
    }
}