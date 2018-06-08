package request;

import java.io.Serializable;

public class ArithmeticRequest implements Serializable, IRequest {
    private String message;
    private String operation;
    private double x;
    private double y;
    private double result = 0.0;

    public ArithmeticRequest(String message) {
    }

    public ArithmeticRequest(String task, double a, double b) {
        operation = task;
        x = a;
        y = b;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }
}
