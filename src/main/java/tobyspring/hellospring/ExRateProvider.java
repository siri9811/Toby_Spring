package tobyspring.hellospring;

import java.io.IOException;
import java.math.BigDecimal;

public interface ExRateProvider {
    BigDecimal getExrate(String currency) throws IOException;
}
