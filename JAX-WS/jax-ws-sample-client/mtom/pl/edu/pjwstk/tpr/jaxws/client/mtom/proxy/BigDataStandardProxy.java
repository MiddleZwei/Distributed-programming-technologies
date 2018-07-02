package pl.edu.pjwstk.tpr.jaxws.client.mtom.proxy;

import com.sun.xml.ws.developer.WSBindingProvider;

import pl.edu.pjwstk.tpr.jaxws.client.common.ProxyBase;
import pl.edu.pjwstk.tpr.jaxws.client.mtom.BigData;
import pl.edu.pjwstk.tpr.jaxws.client.mtom.BigDataStandard;
import pl.edu.pjwstk.tpr.jaxws.client.mtom.BigDataStandardService;

/**
 * @author Edgar G³owacki <edgar@glowacki.eu>
 */
public class BigDataStandardProxy extends ProxyBase implements BigDataStandard {
	
	private BigDataStandardService _service;	
	private BigDataStandard _port;
	
    public BigData get() {
        BigData data = getPort().get();
        return data;
    }
    
    protected WSBindingProvider getBindingProvider() {
		return (WSBindingProvider)getPort();
	}

	private BigDataStandard getPort() {
		if (_service == null) {
			_service = new BigDataStandardService();
		}
		if (_port == null) {
			_port = _service.getBigDataStandardPort();
		}
		return _port;
	}
}