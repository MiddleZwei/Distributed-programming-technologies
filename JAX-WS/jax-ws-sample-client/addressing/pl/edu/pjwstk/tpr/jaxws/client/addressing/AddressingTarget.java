
package pl.edu.pjwstk.tpr.jaxws.client.addressing;

import javax.jws.Oneway;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.8
 * Generated source version: 2.2
 * 
 */
@WebService(name = "AddressingTarget", targetNamespace = "http://addressing.jaxws.tpr.pjwstk.edu.pl/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface AddressingTarget {


    /**
     * 
     * @param arg0
     */
    @WebMethod
    @Oneway
    @RequestWrapper(localName = "replyAddressing", targetNamespace = "http://addressing.jaxws.tpr.pjwstk.edu.pl/", className = "pl.edu.pjwstk.tpr.jaxws.client.addressing.ReplyAddressing")
    @Action(input = "http://addressing.jaxws.tpr.pjwstk.edu.pl/AddressingTarget/replyAddressing")
    public void replyAddressing(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0);

}
