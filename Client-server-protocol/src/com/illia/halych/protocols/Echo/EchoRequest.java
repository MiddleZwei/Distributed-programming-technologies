package com.illia.halych.protocols.Echo;

import com.illia.halych.protocols.IRequest;

public class EchoRequest implements IRequest {
    private String _message;

    public EchoRequest(String[] message) {
        StringBuffer buffer = new StringBuffer();
        for (String arg : message) {
            buffer.append(arg)
                    .append(" ");
        }
        _message = buffer.toString();
    }

    @Override
    public String getMessage(){
        return _message;
    }

    @Override
    public String toString(){
        return getMessage();
    }
}
