package com.illiahalych.RequestResponse;



public class EchoRequest implements IRequest {

    private String _statement;

    public EchoRequest(){}



    public String getStatement(){
        return _statement;
    }
    public void setStatement(String msg){
        _statement = msg;
    }
}
