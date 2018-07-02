package search;

import com.sun.xml.ws.developer.WSBindingProvider;
import pl.edu.pjwstk.tpr.jaxws.client.common.ProxyBase;

import java.util.List;

public class PersonSearchProxy extends ProxyBase implements PersonSearch {

    private PersonSearchService _service;
    private PersonSearch _port;

    @Override
    public List<Person> searchForPeople(SearchQuery query) {
        return getPort().searchForPeople(query);
    }

    @Override
    protected WSBindingProvider getBindingProvider() {
        return (WSBindingProvider)getPort();
    }

    private PersonSearch getPort() {
        if (_service == null) {
            _service = new PersonSearchService();
        }
        if (_port == null) {
            _port = _service.getPersonSearchPort();
        }
        return _port;
    }

}
