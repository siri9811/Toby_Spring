package tobyspring.hellospring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import tobyspring.hellospring.exrate.CachedExRateProvider;
import tobyspring.hellospring.exrate.RestTemplatesExRateProvider;
import tobyspring.hellospring.exrate.ExRateProvider;
import tobyspring.hellospring.payment.PaymentService;

import java.time.Clock;

@Configuration
public class PaymentConfig {
    @Bean
    public PaymentService paymentService() {
        return new PaymentService(cachedexRateProvider(), clock());
    }

    @Bean
    public ExRateProvider cachedexRateProvider() {
        return new CachedExRateProvider(exRateProvider());
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public ExRateProvider exRateProvider() {
        return new RestTemplatesExRateProvider(restTemplate());
    }

    @Bean
    public Clock clock() {
        return Clock.systemDefaultZone();
    }
}
