package pl.edu.pjwstk.tpr.jaxws.ports;

import javax.servlet.annotation.WebServlet;

import com.sun.xml.internal.ws.transport.http.servlet.WSServlet;

@WebServlet("/*")
public class WebServicePort extends WSServlet {

	private static final long serialVersionUID = -6946589644571530717L;
}