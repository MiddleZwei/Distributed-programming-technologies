
package pl.edu.pjwstk.tpr.jaxws.client.delayed;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the pl.edu.pjwstk.tpr.jaxws.client.delayed package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _TprException_QNAME = new QName("http://delayed.jaxws.tpr.pjwstk.edu.pl/", "TprException");
    private final static QName _AddDelayed_QNAME = new QName("http://delayed.jaxws.tpr.pjwstk.edu.pl/", "addDelayed");
    private final static QName _SubtractDelayed_QNAME = new QName("http://delayed.jaxws.tpr.pjwstk.edu.pl/", "subtractDelayed");
    private final static QName _SubtractDelayedResponse_QNAME = new QName("http://delayed.jaxws.tpr.pjwstk.edu.pl/", "subtractDelayedResponse");
    private final static QName _AddDelayedResponse_QNAME = new QName("http://delayed.jaxws.tpr.pjwstk.edu.pl/", "addDelayedResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: pl.edu.pjwstk.tpr.jaxws.client.delayed
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link AddDelayed }
     * 
     */
    public AddDelayed createAddDelayed() {
        return new AddDelayed();
    }

    /**
     * Create an instance of {@link TprException }
     * 
     */
    public TprException createTprException() {
        return new TprException();
    }

    /**
     * Create an instance of {@link AddDelayedResponse }
     * 
     */
    public AddDelayedResponse createAddDelayedResponse() {
        return new AddDelayedResponse();
    }

    /**
     * Create an instance of {@link SubtractDelayedResponse }
     * 
     */
    public SubtractDelayedResponse createSubtractDelayedResponse() {
        return new SubtractDelayedResponse();
    }

    /**
     * Create an instance of {@link SubtractDelayed }
     * 
     */
    public SubtractDelayed createSubtractDelayed() {
        return new SubtractDelayed();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TprException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://delayed.jaxws.tpr.pjwstk.edu.pl/", name = "TprException")
    public JAXBElement<TprException> createTprException(TprException value) {
        return new JAXBElement<TprException>(_TprException_QNAME, TprException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddDelayed }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://delayed.jaxws.tpr.pjwstk.edu.pl/", name = "addDelayed")
    public JAXBElement<AddDelayed> createAddDelayed(AddDelayed value) {
        return new JAXBElement<AddDelayed>(_AddDelayed_QNAME, AddDelayed.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SubtractDelayed }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://delayed.jaxws.tpr.pjwstk.edu.pl/", name = "subtractDelayed")
    public JAXBElement<SubtractDelayed> createSubtractDelayed(SubtractDelayed value) {
        return new JAXBElement<SubtractDelayed>(_SubtractDelayed_QNAME, SubtractDelayed.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SubtractDelayedResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://delayed.jaxws.tpr.pjwstk.edu.pl/", name = "subtractDelayedResponse")
    public JAXBElement<SubtractDelayedResponse> createSubtractDelayedResponse(SubtractDelayedResponse value) {
        return new JAXBElement<SubtractDelayedResponse>(_SubtractDelayedResponse_QNAME, SubtractDelayedResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddDelayedResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://delayed.jaxws.tpr.pjwstk.edu.pl/", name = "addDelayedResponse")
    public JAXBElement<AddDelayedResponse> createAddDelayedResponse(AddDelayedResponse value) {
        return new JAXBElement<AddDelayedResponse>(_AddDelayedResponse_QNAME, AddDelayedResponse.class, null, value);
    }

}
