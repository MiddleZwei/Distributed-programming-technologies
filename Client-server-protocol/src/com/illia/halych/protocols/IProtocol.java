package com.illia.halych.protocols;

public interface IProtocol {
    IResponse deserializeResponse(String input);
    String processRequest(String request);
}
