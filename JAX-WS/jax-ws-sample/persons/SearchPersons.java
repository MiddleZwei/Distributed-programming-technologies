import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;


@WebService
public class SearchPersons {
    private static List<Person> personList;

    static {
        personList = new ArrayList<>();
        for (int i = 1; i < 11; i++) {
            Calendar cal = Calendar.getInstance();
            cal.add(Calendar.YEAR, -i);
            personList.add(new Person(i + "name", i + "surname", cal.getTime()));
        }
    }

    @WebMethod
    public List<Person> searchForPeople(SearchCriteria query) {
        List<Person> result = new ArrayList<>(personList);
        if(query.getSurname() != null) {
            result = result.stream()
                    .filter(p -> p.getSurname().equals(query.getSurname()))
                    .collect(Collectors.toList());
        }
        if(query.getBirthDate() != null) {
            result = result.stream()
                    .filter(p -> DateComparator.areDatesEqual(p.getBirthDate(), query.getBirthDate()))
                    .collect(Collectors.toList());
        }
        return result;
    }
}
