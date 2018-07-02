package pl.edu.pjwstk.tpr.jaxws.client.delayed.proxy.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pl.edu.pjwstk.tpr.jaxws.client.delayed.ReplyDelayedResponse;
import pl.edu.pjwstk.tpr.jaxws.client.delayed.SampleDelayed;
import pl.edu.pjwstk.tpr.jaxws.client.delayed.proxy.SampleDelayedProxy;

import javax.xml.ws.AsyncHandler;
import javax.xml.ws.Response;
import java.util.concurrent.Future;

public class SampleDelayedProxyTest {

    private SampleDelayed _sut;
    private boolean _finished;

    @Before
    public void before() {
        _sut = new SampleDelayedProxy();
        _finished = false;
    }

    @Test
    public void replyDelayed() throws Throwable {
        String request = "request";
        long before = System.currentTimeMillis();
        String response = _sut.replyDelayed(request);
        long after = System.currentTimeMillis();
        Assert.assertEquals("(delayed) Hello, " + request, response);
        Assert.assertTrue(after - before >= 10000);
    }

    @Test
    public void replyDelayedAsync() throws Throwable {
        String request = "request";
        long before = System.currentTimeMillis();
        Response<ReplyDelayedResponse> response = _sut.replyDelayedAsync(request);
        while (!response.isDone()) {
            System.out.println("awaiting response");
            Thread.sleep(2000);
        }
        long after = System.currentTimeMillis();
        Assert.assertEquals("(delayed) Hello, " + request, response.get().getReturn());
        Assert.assertTrue(after - before >= 10000);
    }

    @Test
    public void replyDelayedAsyncHandler() throws Throwable {
        final String request = "request";
        final long before = System.currentTimeMillis();
        final Handler handler = new Handler(request, before);
        Future<?> response = _sut.replyDelayedAsync(request, handler);
        while (!response.isDone()) {
            System.out.println("awaiting response");
            Thread.sleep(2000);
        }
        while (notFinished())
            ;
    }

    private synchronized boolean notFinished() {
        return !_finished;
    }

    private synchronized void setFinished() {
        _finished = true;
    }

    private final class Handler implements AsyncHandler<ReplyDelayedResponse> {

        private final String _request;
        private final long _before;

        private Handler(String request, long before) {
            _request = request;
            _before = before;
        }

        @Override
        public void handleResponse(Response<ReplyDelayedResponse> response) {
            try {
                final long after = System.currentTimeMillis();
                final String result = response.get().getReturn();
                Assert.assertEquals("(delayed) Hello, " + _request, result);
                Assert.assertTrue(after - _before >= 10000);
                System.out.println("result: " + result);
                setFinished();

            } catch (Throwable exception) {
                exception.printStackTrace();
            }
        }
    }
}