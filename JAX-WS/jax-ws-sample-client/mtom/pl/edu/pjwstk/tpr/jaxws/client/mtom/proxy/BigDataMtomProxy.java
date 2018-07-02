package pl.edu.pjwstk.tpr.jaxws.client.mtom.proxy;

import com.sun.xml.ws.developer.WSBindingProvider;

import pl.edu.pjwstk.tpr.jaxws.client.common.ProxyBase;
import pl.edu.pjwstk.tpr.jaxws.client.mtom.BigData;
import pl.edu.pjwstk.tpr.jaxws.client.mtom.BigDataMtom;
import pl.edu.pjwstk.tpr.jaxws.client.mtom.BigDataMtomService;

/**
 * @author Edgar G³owacki <edgar@glowacki.eu>
 */
public class BigDataMtomProxy extends ProxyBase implements BigDataMtom {
	
	private BigDataMtomService _service;	
	private BigDataMtom _port;
	
    public BigData get() {
        BigData data = getPort().get();
        return data;
    }
    
    protected WSBindingProvider getBindingProvider() {
		return (WSBindingProvider)getPort();
	}

	private BigDataMtom getPort() {
		if (_service == null) {
			_service = new BigDataMtomService();
		}
		if (_port == null) {
			_port = _service.getBigDataMtomPort();
		}
		return _port;
	}
}