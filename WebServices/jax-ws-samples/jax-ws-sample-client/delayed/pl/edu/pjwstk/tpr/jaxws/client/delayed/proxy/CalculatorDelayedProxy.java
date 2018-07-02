package pl.edu.pjwstk.tpr.jaxws.client.delayed.proxy;

import com.sun.xml.ws.developer.WSBindingProvider;
import pl.edu.pjwstk.tpr.jaxws.client.common.ProxyBase;
import pl.edu.pjwstk.tpr.jaxws.client.delayed.*;

import javax.xml.ws.AsyncHandler;
import javax.xml.ws.Response;
import java.util.concurrent.Future;

public final class CalculatorDelayedProxy extends ProxyBase implements CalculatorDelayed {

    private CalculatorDelayedService _service;
    private CalculatorDelayed _port;

    public int addDelayed(int component1, int component2) throws TprException_Exception {
        int sum = getPort().addDelayed(component1, component2);
        return sum;
    }

    public Response<AddDelayedResponse> addDelayedAsync(int component1, int component2) {
        Response<AddDelayedResponse> response = getPort().addDelayedAsync(component1, component2);
        return response;
    }

    public Future<?> addDelayedAsync(int component1, int component2, AsyncHandler<AddDelayedResponse> handler) {
        Future<?> future = getPort().addDelayedAsync(component1, component2, handler);
        return future;
    }

    public int subtractDelayed(int minuend, int subtrahend) throws TprException_Exception {
        int difference = getPort().subtractDelayed(minuend, subtrahend);
        return difference;
    }

    public Response<SubtractDelayedResponse> subtractDelayedAsync(int minuend, int subtrahend) {
        Response<SubtractDelayedResponse> response = getPort().subtractDelayedAsync(minuend, subtrahend);
        return response;
    }

    public Future<?> subtractDelayedAsync(int minuend, int subtrahend, AsyncHandler<SubtractDelayedResponse> handler) {
        Future<?> future = getPort().subtractDelayedAsync(minuend, subtrahend, handler);
        return future;
    }

    protected WSBindingProvider getBindingProvider() {
        return (WSBindingProvider) getPort();
    }

    private CalculatorDelayedService getService() {
        if (_service == null) {
            _service = new CalculatorDelayedService();
        }
        return _service;
    }

    private CalculatorDelayed getPort() {
        if (_port == null) {
            _port = getService().getCalculatorDelayedPort();
        }
        return _port;
    }
}