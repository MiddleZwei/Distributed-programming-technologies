package com.illia.halych.protocols.Add;

import com.illia.halych.protocols.IProtocol;
import com.illia.halych.protocols.IResponse;

import java.util.regex.Pattern;

public class AddProtocol implements IProtocol {

    public static final String ADD_COMMAND = "ADD";
    public static final String TOTAL = "TOTAL";
    public static final String SEPARATOR = " ";

    private static final String NUMBER_PATTERN = "([0-9]+)";
    private static final String SEPARATOR_PATTERN = "[ ]";
    private static final String ADD_COMMAND_PATTERN = ADD_COMMAND
            + SEPARATOR_PATTERN + NUMBER_PATTERN
            + SEPARATOR_PATTERN + NUMBER_PATTERN;
    private static Pattern ADD_COMMAND_REGEX;

    private static final String TOTAL_PATTERN = TOTAL + SEPARATOR + NUMBER_PATTERN;
    private static Pattern TOTAL_REGEX;

    static {
        ADD_COMMAND_REGEX = Pattern.compile(ADD_COMMAND_PATTERN);
        TOTAL_REGEX = Pattern.compile(TOTAL_PATTERN);
    }



    @Override
    public IResponse deserializeResponse(String input) {
        return new AddResponse(input);
    }

    @Override
    public String processRequest(String request) {
        return new AddResponse(request).toString();
    }
}
