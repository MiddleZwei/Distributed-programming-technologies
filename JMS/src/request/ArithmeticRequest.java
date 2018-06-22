package request;

import java.io.Serializable;
import java.math.BigDecimal;

public class ArithmeticRequest implements Serializable, IRequest {
    private final BigDecimal param1;
    private final BigDecimal param2;
    private final ArithmeticRequestType type;
    private final String senderName;

    public ArithmeticRequest(BigDecimal param1, BigDecimal param2, ArithmeticRequestType type, String senderName) {
        this.param1 = param1;
        this.param2 = param2;
        this.type = type;
        this.senderName = senderName;
    }

    public BigDecimal getParam1() {
        return param1;
    }

    public BigDecimal getParam2() {
        return param2;
    }

    public ArithmeticRequestType getType() {
        return type;
    }

    @Override
    public String getSenderName() {
        return senderName;
    }

    @Override
    public String toString() {
        return "p1 = " + param1.toString() + " p2 = " + param2.toString() + " | type => " + type;
    }
}
