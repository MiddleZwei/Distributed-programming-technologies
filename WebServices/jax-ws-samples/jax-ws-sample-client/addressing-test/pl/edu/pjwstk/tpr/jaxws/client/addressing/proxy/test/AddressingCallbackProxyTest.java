package pl.edu.pjwstk.tpr.jaxws.client.addressing.proxy.test;

import org.junit.Before;
import org.junit.Test;
import pl.edu.pjwstk.tpr.jaxws.client.addressing.AddressingCallback;
import pl.edu.pjwstk.tpr.jaxws.client.addressing.proxy.AddressingCallbackProxy;

public class AddressingCallbackProxyTest {

    private AddressingCallback _sut;

    @Before
    public void before() {
        _sut = new AddressingCallbackProxy();
    }

    @Test
    public void replyDelayed() {
        String request = "request";
        _sut.replyAddressingCallback(request);
    }
}