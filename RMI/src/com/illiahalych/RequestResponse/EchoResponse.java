package com.illiahalych.RequestResponse;

import java.util.ArrayList;

public class EchoResponse {

    public String _message;

    public EchoResponse(){}

    public void compose(ArrayList<String> words){
        StringBuffer msg = null;
        for(String w : words)
            msg.append(w);
        _message = msg.toString();
    }
}
