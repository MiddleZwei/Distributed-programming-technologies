package pl.edu.pjwstk.tpr.jaxws.client.mtom.proxy.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import pl.edu.pjwstk.tpr.jaxws.client.mtom.BigData;
import pl.edu.pjwstk.tpr.jaxws.client.mtom.BigDataStandard;
import pl.edu.pjwstk.tpr.jaxws.client.mtom.proxy.BigDataStandardProxy;

public final class BigDataStandardProxyTest {
	
	private BigDataStandard _sut;
	
	@Before
	public void before() {
		_sut = new BigDataStandardProxy();
	}

	@Test
	public void get() {
		BigData response = _sut.get();
		Assert.assertNotNull(response);
		Assert.assertNotNull(response.getRawData());
		Assert.assertEquals(response.getSize(), response.getRawData().length);
	}
}