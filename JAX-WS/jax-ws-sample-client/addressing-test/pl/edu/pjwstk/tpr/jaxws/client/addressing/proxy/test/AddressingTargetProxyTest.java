package pl.edu.pjwstk.tpr.jaxws.client.addressing.proxy.test;

import org.junit.Before;
import org.junit.Test;

import pl.edu.pjwstk.tpr.jaxws.client.addressing.AddressingTarget;
import pl.edu.pjwstk.tpr.jaxws.client.addressing.proxy.AddressingTargetProxy;

public class AddressingTargetProxyTest {

private AddressingTarget _sut;
    
    @Before
    public void before() {
        _sut = new AddressingTargetProxy();
    }

    @Test
    public void replyDelayed() throws Throwable {
        String request = "request";
        _sut.replyAddressing(request);
    }
}