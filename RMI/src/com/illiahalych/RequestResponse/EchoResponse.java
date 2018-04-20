package com.illiahalych.RequestResponse;

public class EchoResponse implements IResponse {

    private String _message;

    public EchoResponse(){}

    public String getMessage() {
        return _message;
    }
    public void setMessage(String msg){
        _message = msg;
    }
}
