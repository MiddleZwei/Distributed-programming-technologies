package request;

import exceptions.ConnectionException;
import response.ArithmeticResponse;
import response.IResponse;
import response.RandomResponse;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class RequestProcessor {
    public static IResponse processRequest(IRequest request) {
        if(request instanceof ArithmeticRequest) {
            return processArithmeticRequest((ArithmeticRequest) request);
        } else if (request instanceof RandomRequest) {
            return processRandomRequest((RandomRequest) request);
        }
        else {
            throw new ConnectionException("ILLEGAL REQUEST");
        }
    }

    private static RandomResponse processRandomRequest(RandomRequest request) {
        return new RandomResponse();
    }

    private static ArithmeticResponse processArithmeticRequest(ArithmeticRequest request) {
        BigDecimal param1 = request.getParam1();
        BigDecimal param2 = request.getParam2();

        switch (request.getType()) {
            case ADD:
                return new ArithmeticResponse(param1.add(param2));
            case SUBTRACT:
                return new ArithmeticResponse(param1.subtract(param2));
            case MULTIPLY:
                return new ArithmeticResponse(param1.multiply(param2));
            case DIVIDE:
                return new ArithmeticResponse(param1.divide(param2, RoundingMode.HALF_UP));
        }
        return null;
    }
}
