package pl.edu.pjwstk.tpr.jaxws.ports;

import com.sun.xml.ws.api.SOAPVersion;
import com.sun.xml.ws.api.addressing.AddressingVersion;
import com.sun.xml.ws.api.addressing.WSEndpointReference;
import com.sun.xml.ws.api.message.HeaderList;
import com.sun.xml.ws.developer.JAXWSProperties;

import javax.annotation.Resource;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;

public abstract class WebServiceBase {

    @Resource
    private WebServiceContext _context;

    protected WebServiceContext getWebServiceContext() {
        return _context;
    }

    protected MessageContext getMessageContext() {
        return getWebServiceContext().getMessageContext();
    }

    protected WSEndpointReference getReplyTo() {
        HeaderList headers = getHeaders();
        return headers.getReplyTo(AddressingVersion.W3C, SOAPVersion.SOAP_12);
    }

    protected String getMessageId() {
        HeaderList headers = getHeaders();
        return headers.getMessageID(AddressingVersion.W3C, SOAPVersion.SOAP_12);
    }

    protected void sleep(int millis) throws TprException {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException ex) {
            throw new TprException("error occurred", ex);
        }
    }

    private HeaderList getHeaders() {
        HeaderList headers = (HeaderList) getMessageContext()
                .get(JAXWSProperties.INBOUND_HEADER_LIST_PROPERTY);
        return headers;
    }
}