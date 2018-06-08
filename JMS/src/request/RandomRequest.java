package request;

import java.io.Serializable;

public class RandomRequest implements Serializable, IRequest {
    private String message;

    public RandomRequest() {
    }

    public RandomRequest(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
