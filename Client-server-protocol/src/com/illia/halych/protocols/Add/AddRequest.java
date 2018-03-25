package com.illia.halych.protocols.Add;

import com.illia.halych.protocols.IRequest;

public class AddRequest implements IRequest {
    private String _sum;

    //2 ints
    public AddRequest(int a, int b) {
        int sum = a + b;
        _sum = Integer.toString(sum);
    }

    //many ints
    public AddRequest(int[] numbers) {
        int sum = 0;
        for (int num : numbers)
            sum += num;
        _sum = Integer.toString(sum);
    }

    public AddRequest(double[] numbers) {
        double sum = 0;
        for (double num : numbers)
            sum += num;
        _sum = Double.toString(sum);
    }

    @Override
    public String getMessage(){
        return _sum;
    }

    @Override
    public String toString(){
        return getMessage();
    }
}
