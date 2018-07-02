package pl.edu.pjwstk.tpr.jaxws.client.delayed.proxy.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import pl.edu.pjwstk.tpr.jaxws.client.delayed.CalculatorDelayed;
import pl.edu.pjwstk.tpr.jaxws.client.delayed.proxy.CalculatorDelayedProxy;

public class CalculatorDelayedProxyTest {
	
	private CalculatorDelayed _sut;
	
	@Before
	public void before() {
		_sut = new CalculatorDelayedProxy();
	}

	@Test
	public void addDelayed() throws Throwable {
		int component1 = 2;
		int component2 = 3;
		long before = System.currentTimeMillis();
		int sum = _sut.addDelayed(component1, component2);
		long after = System.currentTimeMillis();
		Assert.assertEquals(component1 + component2, sum);
		Assert.assertTrue(after - before >= 10000);
	}
}