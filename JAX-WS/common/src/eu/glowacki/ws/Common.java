package eu.glowacki.ws;

import java.net.InetAddress;
import java.net.UnknownHostException;

public final class Common {

	private static final String HOST;
	private static final int PORT = 9090;
    public static final String HOST_PORT; 

	static {
		HOST = machineName();
		HOST_PORT = HOST + ":" + PORT;
	}

	private static String machineName() {
		try {
			return InetAddress.getLocalHost().getHostName();
		} catch (UnknownHostException exception) {
			exception.printStackTrace();
			return null;
		}
	}
}