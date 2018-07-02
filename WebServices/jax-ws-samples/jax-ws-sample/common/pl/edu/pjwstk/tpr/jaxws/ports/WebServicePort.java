package pl.edu.pjwstk.tpr.jaxws.ports;

import com.sun.xml.ws.transport.http.servlet.WSServlet;

import javax.servlet.annotation.WebServlet;

@WebServlet("/*")
public class WebServicePort extends WSServlet {

    private static final long serialVersionUID = -6946589644571530717L;
}