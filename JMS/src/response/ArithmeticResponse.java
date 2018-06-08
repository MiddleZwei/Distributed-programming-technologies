package response;

import request.ArithmeticRequest;
import request.IRequest;

import java.io.Serializable;

public class ArithmeticResponse implements Serializable, IResponse {
    private double result = 0.0;
    private ArithmeticRequest request;
    private String message;

    public ArithmeticResponse(ArithmeticRequest request) {
        this.request = request;
    }

    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }

    public String getMessage() {
        switch (request.getOperation())   {
            case "add":
                setResult(request.getX()+request.getY());
        }
        return Double.toString(getResult());
    }

    public void setMessage(String message) {
        this.message = message;
    }


    public ArithmeticRequest getRequest() {
        return request;
    }

    public void setRequest(ArithmeticRequest request) {
        this.request = request;
    }

    public ArithmeticResponse(String msg) {
        setMessage(msg);
    }

    public void perform(){
        
    }


}
