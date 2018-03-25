package com.illia.halych.protocols.Add;

import com.illia.halych.protocols.IProtocol;
import com.illia.halych.protocols.IResponse;

public class AddProtocol implements IProtocol {

    @Override
    public IResponse deserializeResponse(String input) {
        return new AddResponse(input);
    }

    @Override
    public String processRequest(String request) {
        return new AddResponse(request).getMessage();
    }
}
