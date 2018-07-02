package pl.edu.pjwstk.tpr.jaxws.client.common;

import com.sun.xml.ws.api.addressing.AddressingVersion;
import com.sun.xml.ws.api.message.Header;
import com.sun.xml.ws.api.message.Headers;
import com.sun.xml.ws.developer.WSBindingProvider;
import eu.glowacki.ws.Common;

public abstract class ProxyBase {

    protected static final String HOST_PORT = Common.HOST_PORT;

    protected ProxyBase() {
        System.setProperty("proxySet", "true");
        System.setProperty("http.proxyHost", "127.0.0.1");
        System.setProperty("http.proxyPort", "8888");

        // Dump raw messages to the console
        System.setProperty("com.sun.xml.ws.transport.http.client.HttpTransportPipe.dump", "" + true);
    }

    public void setRelatesTo(String messageId) {
        Header header = Headers.create(AddressingVersion.W3C.relatesToTag, messageId);
        getBindingProvider().setOutboundHeaders(header);
    }

    protected abstract WSBindingProvider getBindingProvider();
}