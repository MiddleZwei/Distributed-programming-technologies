package com.illia.halych.protocols.Echo;

import com.illia.halych.protocols.IProtocol;
import com.illia.halych.protocols.IResponse;

public class EchoProtocol implements IProtocol {

    @Override
    public IResponse deserializeResponse(String response) {
        return new EchoResponse(response);
    }

    @Override
    public String processRequest(String request){
        return new EchoResponse(request).getMessage();
    }

}
