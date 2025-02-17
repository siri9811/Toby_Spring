package tobyspring.hellospring.payment;

import java.io.IOException;
import java.math.BigDecimal;

public class ExRateProviderStub implements ExRateProvider {
    public BigDecimal getExRate() {
        return exRate;
    }

    public void setExRate(BigDecimal exRate) {
        this.exRate = exRate;
    }

    private BigDecimal exRate;

    public ExRateProviderStub(BigDecimal exRate) {
        this.exRate = exRate;
    }

    @Override
    public BigDecimal getExrate(String currency) throws IOException {
        return exRate;
    }



}
