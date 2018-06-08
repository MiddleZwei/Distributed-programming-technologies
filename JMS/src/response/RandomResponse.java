package response;

import request.IRequest;
import request.RandomRequest;

import java.io.Serializable;
import java.util.Random;

public class RandomResponse implements Serializable, IResponse {
    private Random rand = new Random();

    public RandomResponse(RandomRequest request) {
    }

    public RandomResponse(IRequest request) {
    }

    public String getMessage() {
        double n = rand.nextDouble();
        return Double.toString(n);
    }
}
