
package pl.edu.pjwstk.tpr.jaxws.client.addressing;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the pl.edu.pjwstk.tpr.jaxws.client.addressing package. 
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

    private final static QName _ReplyAddressingCallback_QNAME = new QName("http://addressing.jaxws.tpr.pjwstk.edu.pl/", "replyAddressingCallback");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: pl.edu.pjwstk.tpr.jaxws.client.addressing
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ReplyAddressingCallback }
     * 
     */
    public ReplyAddressingCallback createReplyAddressingCallback() {
        return new ReplyAddressingCallback();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReplyAddressingCallback }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://addressing.jaxws.tpr.pjwstk.edu.pl/", name = "replyAddressingCallback")
    public JAXBElement<ReplyAddressingCallback> createReplyAddressingCallback(ReplyAddressingCallback value) {
        return new JAXBElement<ReplyAddressingCallback>(_ReplyAddressingCallback_QNAME, ReplyAddressingCallback.class, null, value);
    }

}
