package pl.edu.pjwstk.tpr.jaxws.client.proxy;

import com.sun.xml.ws.developer.WSBindingProvider;

import pl.edu.pjwstk.tpr.jaxws.client.Sample;
import pl.edu.pjwstk.tpr.jaxws.client.SampleService;
import pl.edu.pjwstk.tpr.jaxws.client.common.ProxyBase;

/**
 * @author Edgar G³owacki <edgar@glowacki.eu>
 */
public class SampleProxy extends ProxyBase implements Sample {
	
	private SampleService _service;	
	private Sample _port;

	public String reply(String request) {
		return getPort() //
				.reply(request);
	}
	
	protected WSBindingProvider getBindingProvider() {
		return (WSBindingProvider)getPort();
	}
	
	private Sample getPort() {
		if (_service == null) {
			_service = new SampleService();
		}
		if (_port == null) {
			_port = _service.getSamplePort();
		}
		return _port;
	}
}