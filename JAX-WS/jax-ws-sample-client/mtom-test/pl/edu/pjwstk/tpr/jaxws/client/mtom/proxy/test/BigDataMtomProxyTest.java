package pl.edu.pjwstk.tpr.jaxws.client.mtom.proxy.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import pl.edu.pjwstk.tpr.jaxws.client.mtom.BigData;
import pl.edu.pjwstk.tpr.jaxws.client.mtom.BigDataMtom;
import pl.edu.pjwstk.tpr.jaxws.client.mtom.proxy.BigDataMtomProxy;

public final class BigDataMtomProxyTest {
	
	private BigDataMtom _sut;
	
	@Before
	public void before() {
		_sut = new BigDataMtomProxy();
	}

	@Test
	public void get() {
		BigData response = _sut.get();
		Assert.assertNotNull(response);
		int size = response.getSize();
		byte[] array = response.getRawData();
		Assert.assertNotNull(array);
		Assert.assertEquals(size, array.length);
	}
}