package com.illiahalych.RequestResponse;



public class AddResponse implements IResponse {

    private int _sum;

    public AddResponse(){}

    public int getSum(){
        return _sum;
    }
    public void setSum(int sum){
        _sum = sum;
    }


    
}
