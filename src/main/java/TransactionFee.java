package main.java;
import java.math.BigDecimal;

public interface TransactionFee {
    BigDecimal applyFee(BigDecimal amount);
}
