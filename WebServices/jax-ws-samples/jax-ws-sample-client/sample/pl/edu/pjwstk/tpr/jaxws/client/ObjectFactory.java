
package pl.edu.pjwstk.tpr.jaxws.client;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the pl.edu.pjwstk.tpr.jaxws.client package. 
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

    private final static QName _SearchForPeopleResponse_QNAME = new QName("http://search/", "searchForPeopleResponse");
    private final static QName _SearchForPeople_QNAME = new QName("http://search/", "searchForPeople");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: pl.edu.pjwstk.tpr.jaxws.client
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link SearchForPeopleResponse }
     * 
     */
    public SearchForPeopleResponse createSearchForPeopleResponse() {
        return new SearchForPeopleResponse();
    }

    /**
     * Create an instance of {@link SearchForPeople }
     * 
     */
    public SearchForPeople createSearchForPeople() {
        return new SearchForPeople();
    }

    /**
     * Create an instance of {@link Person }
     * 
     */
    public Person createPerson() {
        return new Person();
    }

    /**
     * Create an instance of {@link SearchQuery }
     * 
     */
    public SearchQuery createSearchQuery() {
        return new SearchQuery();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SearchForPeopleResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://search/", name = "searchForPeopleResponse")
    public JAXBElement<SearchForPeopleResponse> createSearchForPeopleResponse(SearchForPeopleResponse value) {
        return new JAXBElement<SearchForPeopleResponse>(_SearchForPeopleResponse_QNAME, SearchForPeopleResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SearchForPeople }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://search/", name = "searchForPeople")
    public JAXBElement<SearchForPeople> createSearchForPeople(SearchForPeople value) {
        return new JAXBElement<SearchForPeople>(_SearchForPeople_QNAME, SearchForPeople.class, null, value);
    }

}
