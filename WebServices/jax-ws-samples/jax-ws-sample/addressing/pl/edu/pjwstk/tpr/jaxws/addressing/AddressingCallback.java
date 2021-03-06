package pl.edu.pjwstk.tpr.jaxws.addressing;

import pl.edu.pjwstk.tpr.jaxws.ports.WebServiceBase;

import javax.jws.Oneway;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.ws.soap.Addressing;

@Addressing(enabled = true, required = true)
@WebService
public class AddressingCallback extends WebServiceBase {

    @Oneway
    @WebMethod
    public void replyAddressingCallback(String response) {
        System.out.println(response);
    }
}