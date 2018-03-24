package com.illia.halych.protocols;

import com.illia.halych.protocols.Add.AddProtocol;
import com.illia.halych.protocols.Echo.EchoProtocol;

public class Commons {

    public static final String MODE_ADD = "ADD";
    public static final String MODE_ECHO = "ECHO";

    public static int PORT = 1111;
    public static final int BUFFER_SIZE = 4096;

    public static IProtocol getProtocol(String mode) {
        IProtocol protocol = null;
        switch (mode){
            case MODE_ADD:
                protocol = new AddProtocol();
                break;
            case MODE_ECHO:
                protocol = new EchoProtocol();
                break;
        }
        return protocol;
    }
}
