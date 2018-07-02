package pl.edu.pjwstk.tpr.jaxws.client.addressing.proxy;

import javax.xml.ws.WebServiceFeature;
import javax.xml.ws.soap.AddressingFeature;

import com.sun.xml.ws.api.addressing.AddressingVersion;
import com.sun.xml.ws.api.addressing.OneWayFeature;
import com.sun.xml.ws.api.addressing.WSEndpointReference;
import com.sun.xml.ws.developer.WSBindingProvider;

import pl.edu.pjwstk.tpr.jaxws.client.addressing.AddressingTarget;
import pl.edu.pjwstk.tpr.jaxws.client.addressing.AddressingTargetService;
import pl.edu.pjwstk.tpr.jaxws.client.common.ProxyBase;

public class AddressingTargetProxy extends ProxyBase implements AddressingTarget {

	private static final String REPLY_TO_URI = "http://" + HOST_PORT + "/jax-ws-sample/addressing-callback";

	private AddressingTargetService _service;
	private AddressingTarget _port;

	public void replyAddressing(String request) {
		getPort().replyAddressing(request);
	}

	protected WSBindingProvider getBindingProvider() {
		return (WSBindingProvider) getPort();
	}

	private AddressingTarget getPort() {
		if (_service == null) {
			_service = new AddressingTargetService();
		}
		if (_port == null) {
			WebServiceFeature addressing = new AddressingFeature(true, true);
			WSEndpointReference replyToEpr = new WSEndpointReference(REPLY_TO_URI, AddressingVersion.W3C);
			WebServiceFeature oneWay = new OneWayFeature(true, replyToEpr);
			_port = _service.getAddressingTargetPort(addressing, oneWay);
		}
		return _port;
	}
}