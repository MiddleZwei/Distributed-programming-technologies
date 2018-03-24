package com.illia.halych.protocols.Echo;

import com.illia.halych.protocols.IResponse;

public class EchoResponse implements IResponse {
    private final String _message;

    public EchoResponse(String message) {
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
