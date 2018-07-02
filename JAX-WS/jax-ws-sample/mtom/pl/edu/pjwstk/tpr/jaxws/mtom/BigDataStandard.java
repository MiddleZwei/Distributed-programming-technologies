package pl.edu.pjwstk.tpr.jaxws.mtom;

import javax.jws.WebMethod;
import javax.jws.WebService;

import pl.edu.pjwstk.tpr.jaxws.ports.WebServiceBase;

@WebService
public class BigDataStandard extends WebServiceBase {

    @WebMethod
    public BigData get() {
        BigData data = BigData.generate();
        return data;
    }
}