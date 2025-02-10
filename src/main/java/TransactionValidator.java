package main.java;
import java.math.BigDecimal;

public interface TransactionValidator {
    boolean validate(BigDecimal amount);
}
