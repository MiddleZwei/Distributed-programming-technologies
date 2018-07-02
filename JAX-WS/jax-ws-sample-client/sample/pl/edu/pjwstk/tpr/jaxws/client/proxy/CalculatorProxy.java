package pl.edu.pjwstk.tpr.jaxws.client.proxy;

import com.sun.xml.ws.developer.WSBindingProvider;

import pl.edu.pjwstk.tpr.jaxws.client.Calculator;
import pl.edu.pjwstk.tpr.jaxws.client.CalculatorService;
import pl.edu.pjwstk.tpr.jaxws.client.common.ProxyBase;

public class CalculatorProxy extends ProxyBase implements Calculator {

	private CalculatorService _service;
	private Calculator _port;
	
	public int add(int component1, int component2) {
		int sum = getPort().add(component1, component2);
		return sum;
	}

	public int subtract(int minuend, int subtrahend) {
		int difference = getPort().subtract(minuend, subtrahend);
		return difference;
	}
	
	protected WSBindingProvider getBindingProvider() {
		return (WSBindingProvider)getPort();
	}
	
	private Calculator getPort() {
		if (_service == null) {
			_service = new CalculatorService();
		}
		if (_port == null) {
			_port = _service.getCalculatorPort();
		}
		return _port;
	}
}