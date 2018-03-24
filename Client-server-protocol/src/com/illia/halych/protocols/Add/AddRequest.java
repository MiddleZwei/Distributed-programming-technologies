package com.illia.halych.protocols.Add;

import com.illia.halych.protocols.IRequest;

public class AddRequest implements IRequest {
    public AddRequest(int a, int b) {
    }

    public AddRequest(String request) {

    }

    @Override
    public String getMessage() {
        return null;
    }
}
