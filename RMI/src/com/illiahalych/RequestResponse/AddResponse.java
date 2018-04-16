package com.illiahalych.RequestResponse;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AddResponse implements IResponse {
    private final String _message;
    private final String regex = "\\d([.]\\d)?";
    private String _sum = "";

    public AddResponse(String input) {
        _message = input;
        addNumbers(_message);
    }

    private void addNumbers(String message) {
        double sum = 0;
        ArrayList<Double> numbers = findNums(message);
        for (Double num : numbers)
            sum += num;
        _sum = Double.toString(sum);
    }

    private ArrayList<Double> findNums(String message) {
        ArrayList<Double> nums = new ArrayList<Double>();
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(message);
        while (m.find()) {
            nums.add(Double.parseDouble(m.group()));
            System.out.println("Added: "+m.group());
        }
        return nums;
    }

    public String getMessage(){
        return _sum;
    }

    public String toString(){
        return getMessage();
    }
}
