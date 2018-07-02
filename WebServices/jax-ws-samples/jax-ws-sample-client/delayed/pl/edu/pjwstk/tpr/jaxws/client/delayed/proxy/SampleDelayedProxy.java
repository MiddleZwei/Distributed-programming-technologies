package pl.edu.pjwstk.tpr.jaxws.client.delayed.proxy;

import com.sun.xml.ws.developer.WSBindingProvider;
import pl.edu.pjwstk.tpr.jaxws.client.common.ProxyBase;
import pl.edu.pjwstk.tpr.jaxws.client.delayed.ReplyDelayedResponse;
import pl.edu.pjwstk.tpr.jaxws.client.delayed.SampleDelayed;
import pl.edu.pjwstk.tpr.jaxws.client.delayed.SampleDelayedService;
import pl.edu.pjwstk.tpr.jaxws.client.delayed.TprException_Exception;

import javax.xml.ws.AsyncHandler;
import javax.xml.ws.Response;
import java.util.concurrent.Future;

/**
 * @author Edgar G�owacki <edgar@glowacki.eu>
 */
public final class SampleDelayedProxy extends ProxyBase implements SampleDelayed {

    private SampleDelayedService _service;
    private SampleDelayed _port;

    public String replyDelayed(String request) throws TprException_Exception {
        return getPort().replyDelayed(request);
    }

    public Response<ReplyDelayedResponse> replyDelayedAsync(String request) {
        Response<ReplyDelayedResponse> response = getPort().replyDelayedAsync(request);
        return response;
    }

    public Future<?> replyDelayedAsync(String request, AsyncHandler<ReplyDelayedResponse> handler) {
        Future<?> future = getPort().replyDelayedAsync(request, handler);
        return future;
    }

    protected WSBindingProvider getBindingProvider() {
        return (WSBindingProvider) getPort();
    }

    private SampleDelayedService getService() {
        if (_service == null) {
            _service = new SampleDelayedService();
        }
        return _service;
    }

    private SampleDelayed getPort() {
        if (_port == null) {
            _port = getService().getSampleDelayedPort();
        }
        return _port;
    }
}