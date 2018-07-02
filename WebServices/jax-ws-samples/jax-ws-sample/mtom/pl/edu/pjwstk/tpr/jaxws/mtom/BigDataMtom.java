package pl.edu.pjwstk.tpr.jaxws.mtom;

import pl.edu.pjwstk.tpr.jaxws.ports.WebServiceBase;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.ws.soap.MTOM;

@MTOM
@WebService
public class BigDataMtom extends WebServiceBase {

    @WebMethod
    public BigData get() {
        BigData data = BigData.generate();
        return data;
    }
}