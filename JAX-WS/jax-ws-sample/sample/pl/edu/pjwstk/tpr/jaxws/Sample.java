package pl.edu.pjwstk.tpr.jaxws;

import javax.jws.WebMethod;
import javax.jws.WebService;

import pl.edu.pjwstk.tpr.jaxws.ports.WebServiceBase;

@WebService
public class Sample extends WebServiceBase {
    
	@WebMethod
	public String reply(String request) {
		String response =  "Hello, " + request;
		return response;
	}
}