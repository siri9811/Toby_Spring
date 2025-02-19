package tobyspring.hellospring.exrate;

import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;

public class RestTemplatesExRateProvider implements ExRateProvider {
    private final RestTemplate restTemplate;

    public RestTemplatesExRateProvider(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public BigDecimal getExrate(String currency) {
        String url = "https://open.er-api.com/v6/latest/" + currency;

        return restTemplate.getForObject(url, ExRateData.class).rates().get("KRW");
    }


}
