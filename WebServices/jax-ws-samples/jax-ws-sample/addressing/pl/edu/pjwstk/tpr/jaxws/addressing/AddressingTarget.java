package pl.edu.pjwstk.tpr.jaxws.addressing;

import com.sun.xml.ws.api.addressing.WSEndpointReference;
import pl.edu.pjwstk.tpr.jaxws.client.addressing.proxy.AddressingCallbackProxy;
import pl.edu.pjwstk.tpr.jaxws.ports.WebServiceBase;

import javax.jws.Oneway;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.ws.BindingType;
import javax.xml.ws.soap.Addressing;

@Addressing(enabled = true, required = true)
@WebService
@BindingType(value = "http://schemas.xmlsoap.org/wsdl/soap/http")
public class AddressingTarget extends WebServiceBase {

    private AddressingCallbackProxy _callbackProxy;

    @Oneway
    @WebMethod
    public void replyAddressing(String request) {
        WSEndpointReference epr = getReplyTo();
        String messageId = getMessageId();
        AddressingCallbackProxy proxy = getCallbackProxy();
        proxy.setRelatesTo(messageId);
        String response = "REPLY-TO: " + request;
        proxy.replyAddressingCallback(response);
    }

    private AddressingCallbackProxy getCallbackProxy() {
        if (_callbackProxy == null) {
            _callbackProxy = new AddressingCallbackProxy();
        }
        return _callbackProxy;
    }
}