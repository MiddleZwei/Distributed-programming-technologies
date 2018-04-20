package com.illiahalych.RequestResponse;




public class AddRequest implements IRequest {

    private int _a;
    private int _b;

    public AddRequest(){}

    public int getA(){
        return _a;
    }
    public void setA(int a){
        _a = a;
    }

    public int getB(){
        return _b;
    }
    public void setB(int b){
        _b = b;
    }
}
