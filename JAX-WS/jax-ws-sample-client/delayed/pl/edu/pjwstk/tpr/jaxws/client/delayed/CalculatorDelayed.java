
package pl.edu.pjwstk.tpr.jaxws.client.delayed;

import java.util.concurrent.Future;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.AsyncHandler;
import javax.xml.ws.FaultAction;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.Response;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.8
 * Generated source version: 2.2
 * 
 */
@WebService(name = "CalculatorDelayed", targetNamespace = "http://delayed.jaxws.tpr.pjwstk.edu.pl/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface CalculatorDelayed {


    /**
     * 
     * @param arg1
     * @param arg0
     * @return
     *     returns javax.xml.ws.Response<pl.edu.pjwstk.tpr.jaxws.client.delayed.AddDelayedResponse>
     */
    @WebMethod(operationName = "addDelayed")
    @RequestWrapper(localName = "addDelayed", targetNamespace = "http://delayed.jaxws.tpr.pjwstk.edu.pl/", className = "pl.edu.pjwstk.tpr.jaxws.client.delayed.AddDelayed")
    @ResponseWrapper(localName = "addDelayedResponse", targetNamespace = "http://delayed.jaxws.tpr.pjwstk.edu.pl/", className = "pl.edu.pjwstk.tpr.jaxws.client.delayed.AddDelayedResponse")
    public Response<AddDelayedResponse> addDelayedAsync(
        @WebParam(name = "arg0", targetNamespace = "")
        int arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        int arg1);

    /**
     * 
     * @param arg1
     * @param arg0
     * @param asyncHandler
     * @return
     *     returns java.util.concurrent.Future<? extends java.lang.Object>
     */
    @WebMethod(operationName = "addDelayed")
    @RequestWrapper(localName = "addDelayed", targetNamespace = "http://delayed.jaxws.tpr.pjwstk.edu.pl/", className = "pl.edu.pjwstk.tpr.jaxws.client.delayed.AddDelayed")
    @ResponseWrapper(localName = "addDelayedResponse", targetNamespace = "http://delayed.jaxws.tpr.pjwstk.edu.pl/", className = "pl.edu.pjwstk.tpr.jaxws.client.delayed.AddDelayedResponse")
    public Future<?> addDelayedAsync(
        @WebParam(name = "arg0", targetNamespace = "")
        int arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        int arg1,
        @WebParam(name = "asyncHandler", targetNamespace = "")
        AsyncHandler<AddDelayedResponse> asyncHandler);

    /**
     * 
     * @param arg1
     * @param arg0
     * @return
     *     returns int
     * @throws TprException_Exception
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "addDelayed", targetNamespace = "http://delayed.jaxws.tpr.pjwstk.edu.pl/", className = "pl.edu.pjwstk.tpr.jaxws.client.delayed.AddDelayed")
    @ResponseWrapper(localName = "addDelayedResponse", targetNamespace = "http://delayed.jaxws.tpr.pjwstk.edu.pl/", className = "pl.edu.pjwstk.tpr.jaxws.client.delayed.AddDelayedResponse")
    @Action(input = "http://delayed.jaxws.tpr.pjwstk.edu.pl/CalculatorDelayed/addDelayedRequest", output = "http://delayed.jaxws.tpr.pjwstk.edu.pl/CalculatorDelayed/addDelayedResponse", fault = {
        @FaultAction(className = TprException_Exception.class, value = "http://delayed.jaxws.tpr.pjwstk.edu.pl/CalculatorDelayed/addDelayed/Fault/TprException")
    })
    public int addDelayed(
        @WebParam(name = "arg0", targetNamespace = "")
        int arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        int arg1)
        throws TprException_Exception
    ;

    /**
     * 
     * @param arg1
     * @param arg0
     * @return
     *     returns javax.xml.ws.Response<pl.edu.pjwstk.tpr.jaxws.client.delayed.SubtractDelayedResponse>
     */
    @WebMethod(operationName = "subtractDelayed")
    @RequestWrapper(localName = "subtractDelayed", targetNamespace = "http://delayed.jaxws.tpr.pjwstk.edu.pl/", className = "pl.edu.pjwstk.tpr.jaxws.client.delayed.SubtractDelayed")
    @ResponseWrapper(localName = "subtractDelayedResponse", targetNamespace = "http://delayed.jaxws.tpr.pjwstk.edu.pl/", className = "pl.edu.pjwstk.tpr.jaxws.client.delayed.SubtractDelayedResponse")
    public Response<SubtractDelayedResponse> subtractDelayedAsync(
        @WebParam(name = "arg0", targetNamespace = "")
        int arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        int arg1);

    /**
     * 
     * @param arg1
     * @param arg0
     * @param asyncHandler
     * @return
     *     returns java.util.concurrent.Future<? extends java.lang.Object>
     */
    @WebMethod(operationName = "subtractDelayed")
    @RequestWrapper(localName = "subtractDelayed", targetNamespace = "http://delayed.jaxws.tpr.pjwstk.edu.pl/", className = "pl.edu.pjwstk.tpr.jaxws.client.delayed.SubtractDelayed")
    @ResponseWrapper(localName = "subtractDelayedResponse", targetNamespace = "http://delayed.jaxws.tpr.pjwstk.edu.pl/", className = "pl.edu.pjwstk.tpr.jaxws.client.delayed.SubtractDelayedResponse")
    public Future<?> subtractDelayedAsync(
        @WebParam(name = "arg0", targetNamespace = "")
        int arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        int arg1,
        @WebParam(name = "asyncHandler", targetNamespace = "")
        AsyncHandler<SubtractDelayedResponse> asyncHandler);

    /**
     * 
     * @param arg1
     * @param arg0
     * @return
     *     returns int
     * @throws TprException_Exception
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "subtractDelayed", targetNamespace = "http://delayed.jaxws.tpr.pjwstk.edu.pl/", className = "pl.edu.pjwstk.tpr.jaxws.client.delayed.SubtractDelayed")
    @ResponseWrapper(localName = "subtractDelayedResponse", targetNamespace = "http://delayed.jaxws.tpr.pjwstk.edu.pl/", className = "pl.edu.pjwstk.tpr.jaxws.client.delayed.SubtractDelayedResponse")
    @Action(input = "http://delayed.jaxws.tpr.pjwstk.edu.pl/CalculatorDelayed/subtractDelayedRequest", output = "http://delayed.jaxws.tpr.pjwstk.edu.pl/CalculatorDelayed/subtractDelayedResponse", fault = {
        @FaultAction(className = TprException_Exception.class, value = "http://delayed.jaxws.tpr.pjwstk.edu.pl/CalculatorDelayed/subtractDelayed/Fault/TprException")
    })
    public int subtractDelayed(
        @WebParam(name = "arg0", targetNamespace = "")
        int arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        int arg1)
        throws TprException_Exception
    ;

}
