package com.illia.halych.protocols.Echo;

import com.illia.halych.protocols.IRequest;

public class EchoRequest implements IRequest {
    private final String _message;

    public EchoRequest(String message) {
        _message = message;
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
