import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import search.Person;
import search.PersonSearchProxy;
import search.SearchQuery;

import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

public class PeopleSearchTest {

    private List<Person> personList;
    private PersonSearchProxy personSearchProxy;

    @Test
    public void findBySurname() {
        for (Person expected : personList) {
            SearchQuery query = new SearchQuery();
            query.setSurname(expected.getSurname());
            List<Person> actualList = personSearchProxy.searchForPeople(query);
            Assert.assertEquals(1, actualList.size());
            Assert.assertEquals(expected, actualList.get(0));
        }
    }


    @Test
    public void findByBirthDate() {
        for (Person expected : personList) {
            SearchQuery query = new SearchQuery();
            query.setBirthDate(expected.getBirthDate());
            List<Person> actualList = personSearchProxy.searchForPeople(query);
            Assert.assertEquals(1, actualList.size());
            Assert.assertEquals(expected, actualList.get(0));
        }
    }

    @Test
    public void findBySurnameBirthDate() {
        for (Person expected : personList) {
            SearchQuery query = new SearchQuery();
            query.setSurname(expected.getSurname());
            query.setBirthDate(expected.getBirthDate());
            List<Person> actualList = personSearchProxy.searchForPeople(query);
            Assert.assertEquals(1, actualList.size());
            Assert.assertEquals(expected, actualList.get(0));
        }
    }

    @Before
    public void setUp() throws Exception {
        personList = new ArrayList<>();
        DatatypeFactory datatypeFactory = DatatypeFactory.newInstance();
        for (int i = 1; i < 11; i++) {
            Person p = new Person();
            p.setFirstName(i + "name");
            p.setSurname(i + "surname");

            GregorianCalendar cal = new GregorianCalendar();
            cal.add(Calendar.YEAR, -i);
            XMLGregorianCalendar xmlCal = datatypeFactory.newXMLGregorianCalendar(cal);
            p.setBirthDate(xmlCal);
            personList.add(p);
        }
        personSearchProxy = new PersonSearchProxy();
    }

    @After
    public void tearDown() throws Exception {
        personList = null;
        personSearchProxy = null;
    }
}
