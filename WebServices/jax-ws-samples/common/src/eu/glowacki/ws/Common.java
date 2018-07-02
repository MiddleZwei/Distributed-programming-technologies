package eu.glowacki.ws;

import java.net.InetAddress;
import java.net.UnknownHostException;

public final class Common {

    public static final String HOST_PORT;
    private static final String HOST;
    private static final int PORT = 9090;

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