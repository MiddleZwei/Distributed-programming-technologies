
package pl.edu.pjwstk.tpr.jaxws.client;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.8
 * Generated source version: 2.2
 * 
 */
@WebService(name = "Calculator", targetNamespace = "http://jaxws.tpr.pjwstk.edu.pl/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface Calculator {


    /**
     * 
     * @param arg1
     * @param arg0
     * @return
     *     returns int
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "subtract", targetNamespace = "http://jaxws.tpr.pjwstk.edu.pl/", className = "pl.edu.pjwstk.tpr.jaxws.client.Subtract")
    @ResponseWrapper(localName = "subtractResponse", targetNamespace = "http://jaxws.tpr.pjwstk.edu.pl/", className = "pl.edu.pjwstk.tpr.jaxws.client.SubtractResponse")
    @Action(input = "http://jaxws.tpr.pjwstk.edu.pl/Calculator/subtractRequest", output = "http://jaxws.tpr.pjwstk.edu.pl/Calculator/subtractResponse")
    public int subtract(
        @WebParam(name = "arg0", targetNamespace = "")
        int arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        int arg1);

    /**
     * 
     * @param arg1
     * @param arg0
     * @return
     *     returns int
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "add", targetNamespace = "http://jaxws.tpr.pjwstk.edu.pl/", className = "pl.edu.pjwstk.tpr.jaxws.client.Add")
    @ResponseWrapper(localName = "addResponse", targetNamespace = "http://jaxws.tpr.pjwstk.edu.pl/", className = "pl.edu.pjwstk.tpr.jaxws.client.AddResponse")
    @Action(input = "http://jaxws.tpr.pjwstk.edu.pl/Calculator/addRequest", output = "http://jaxws.tpr.pjwstk.edu.pl/Calculator/addResponse")
    public int add(
        @WebParam(name = "arg0", targetNamespace = "")
        int arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        int arg1);

}
