package com.webservice.SOAPWebService.repository;

import com.sun.javafx.collections.MappingChange;
import io.spring.guides.gs_producing_web_service.Person;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Component
public class PersonRepository {
    private static Map<String, Person> persons = new HashMap<>();

    @PostConstruct
    public void initData(){
        Person ala = new Person();
        ala.setFirstName("Ala");
        ala.setLastName("Kot");
        ala.setBithDate("June 1st");
        persons.put(ala.getFirstName(), ala);

        Person illia = new Person();
        ala.setFirstName("Illia");
        ala.setLastName("Halych");
        ala.setBithDate("February 1st");
        persons.put(illia.getFirstName(), illia);

        Person john = new Person();
        ala.setFirstName("John");
        ala.setLastName("Crowder");
        ala.setBithDate("July 1st");
        persons.put(john.getFirstName(), john);
    }

    public Person findPerson(String lastName) {
        Assert.notNull(lastName, "The persons's last name must not be null");
        return persons.get(lastName);
    }

}
