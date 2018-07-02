package search;

import javax.xml.namespace.QName;
import javax.xml.ws.*;
import java.net.MalformedURLException;
import java.net.URL;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.8
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "PersonSearchService", targetNamespace = "http://search/", wsdlLocation = "http://localhost:8080/jax-ws-sample/personSearch?wsdl")
public class PersonSearchService
    extends Service
{

    private final static URL PERSONSEARCHSERVICE_WSDL_LOCATION;
    private final static WebServiceException PERSONSEARCHSERVICE_EXCEPTION;
    private final static QName PERSONSEARCHSERVICE_QNAME = new QName("http://search/", "PersonSearchService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:8080/jax-ws-sample/personSearch?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        PERSONSEARCHSERVICE_WSDL_LOCATION = url;
        PERSONSEARCHSERVICE_EXCEPTION = e;
    }

    public PersonSearchService() {
        super(__getWsdlLocation(), PERSONSEARCHSERVICE_QNAME);
    }

    public PersonSearchService(WebServiceFeature... features) {
        super(__getWsdlLocation(), PERSONSEARCHSERVICE_QNAME, features);
    }

    public PersonSearchService(URL wsdlLocation) {
        super(wsdlLocation, PERSONSEARCHSERVICE_QNAME);
    }

    public PersonSearchService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, PERSONSEARCHSERVICE_QNAME, features);
    }

    public PersonSearchService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public PersonSearchService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns search.PersonSearch
     */
    @WebEndpoint(name = "PersonSearchPort")
    public PersonSearch getPersonSearchPort() {
        return super.getPort(new QName("http://search/", "PersonSearchPort"), PersonSearch.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns search.PersonSearch
     */
    @WebEndpoint(name = "PersonSearchPort")
    public PersonSearch getPersonSearchPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://search/", "PersonSearchPort"), PersonSearch.class, features);
    }

    private static URL __getWsdlLocation() {
        if (PERSONSEARCHSERVICE_EXCEPTION!= null) {
            throw PERSONSEARCHSERVICE_EXCEPTION;
        }
        return PERSONSEARCHSERVICE_WSDL_LOCATION;
    }

}
