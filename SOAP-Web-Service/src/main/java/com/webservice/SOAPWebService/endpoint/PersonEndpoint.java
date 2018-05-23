package com.webservice.SOAPWebService.endpoint;

import com.webservice.SOAPWebService.repository.PersonRepository;
import io.spring.guides.gs_producing_web_service.GetPersonRequest;
import io.spring.guides.gs_producing_web_service.GetPersonResponse;
import io.spring.guides.gs_producing_web_service.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class PersonEndpoint {
    private static final String NAMESPACE_URI = "http://spring.io/guides/gs-producing-web-service";

    private PersonRepository personRepository;

    @Autowired
    public PersonEndpoint(PersonRepository personRepository){
        this.personRepository = personRepository;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getPersonRequest")
    @ResponsePayload
    public GetPersonResponse getPerson(@RequestPayload GetPersonRequest request){
        GetPersonResponse response = new GetPersonResponse();
        response.setPerson(personRepository.findPerson(request.getLastName()));

        return response;
    }
}
