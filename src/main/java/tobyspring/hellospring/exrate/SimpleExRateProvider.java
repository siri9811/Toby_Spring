package tobyspring.hellospring.exrate;

import java.math.BigDecimal;


public class SimpleExRateProvider implements ExRateProvider {

    @Override
    public BigDecimal getExrate(String currency) {
        if (currency.equals("USD")) return BigDecimal.valueOf(1000);

        throw new IllegalArgumentException("지원되지 않는 통화입니다");
    }
}
