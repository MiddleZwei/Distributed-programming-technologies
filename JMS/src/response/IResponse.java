package response;

import java.io.Serializable;
import java.math.BigDecimal;

public interface IResponse extends Serializable {
    BigDecimal getResult();
}
