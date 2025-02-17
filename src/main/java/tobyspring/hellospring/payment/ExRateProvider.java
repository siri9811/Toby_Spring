package tobyspring.hellospring.payment;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.URISyntaxException;

public interface ExRateProvider {
    BigDecimal getExrate(String currency) throws IOException, URISyntaxException;

}