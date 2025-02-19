package tobyspring.hellospring.payment;


import tobyspring.hellospring.exrate.ExRateProvider;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.URISyntaxException;
import java.time.Clock;
import java.time.LocalDateTime;


public class PaymentService {
    private final ExRateProvider exRateProvider;
    private final Clock clock;

    public PaymentService(ExRateProvider exRateProvider, Clock clock) {
        this.exRateProvider = exRateProvider;
        this.clock = clock;
    }

    public Payment prepare(Long orderId, String currency,
                           BigDecimal foreignCurrencyAmount) throws IOException, URISyntaxException {

        return Payment.createPrepared(orderId, currency,
                foreignCurrencyAmount, exRateProvider.getExrate(currency), LocalDateTime.now(clock));
    }
}
