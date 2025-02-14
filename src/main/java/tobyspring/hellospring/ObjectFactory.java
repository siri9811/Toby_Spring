package tobyspring.hellospring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ObjectFactory  {
    @Bean
    public PaymentService paymentService() {
        return new PaymentService(cachedexRateProvider());
    }

    @Bean
    public ExRateProvider cachedexRateProvider() {
        return new CachedExRateProvider(exRateProvider());
    }

    @Bean
    public ExRateProvider exRateProvider() {
        return new WebApiExRateProvider();
    }
}
