package com.illia.halych.protocols.Add;

import com.illia.halych.protocols.IRequest;

public class AddRequest implements IRequest {
    private String nums;

    public AddRequest(String[] numbers) {
        StringBuffer buffer = new StringBuffer();
        for (String arg : numbers) {
            buffer.append(arg)
                    .append(" ");
            }
        nums = buffer.toString();

    }

    @Override
    public String getMessage(){
        return nums;
    }

    @Override
    public String toString(){
        return getMessage();
    }
}
