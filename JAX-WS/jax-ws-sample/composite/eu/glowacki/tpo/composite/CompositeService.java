package eu.glowacki.tpo.composite;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public class CompositeService {

	@WebMethod
	public CompositeResponse getCompositeValue(CompositeRequest request) {
		CompositeResponse response = new CompositeResponse();
		response._protected = request._protected;
		return response;
	}
}