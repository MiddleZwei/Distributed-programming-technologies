package com.illia.halych.protocols.Add;

import com.illia.halych.protocols.IResponse;

public class AddResponse implements IResponse {
    private final String _message;

    public AddResponse(String input) {
        _message = input;
    }

    public String getMessage(){
        return _message;
    }

    public String toString(){
        return getMessage();
    }
}
