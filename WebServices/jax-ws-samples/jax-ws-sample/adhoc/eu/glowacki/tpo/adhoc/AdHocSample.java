package eu.glowacki.tpo.adhoc;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public class AdHocSample {

    @WebMethod
    public String adHocEcho(String message) {
        return "Ad hoc echoed: " + message;
    }
}