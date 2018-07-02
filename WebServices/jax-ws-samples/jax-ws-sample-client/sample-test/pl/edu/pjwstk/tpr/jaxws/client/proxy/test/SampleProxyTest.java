package pl.edu.pjwstk.tpr.jaxws.client.proxy.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pl.edu.pjwstk.tpr.jaxws.client.Sample;
import pl.edu.pjwstk.tpr.jaxws.client.proxy.SampleProxy;

public final class SampleProxyTest {

    private Sample _sut;

    @Before
    public void before() {
        _sut = new SampleProxy();
    }

    @Test
    public void reply() {
        final String request = "request";
        final String response = _sut.reply(request);
        Assert.assertEquals("Hello, " + request, response);
    }
}