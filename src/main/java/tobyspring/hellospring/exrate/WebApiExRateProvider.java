package tobyspring.hellospring.exrate;


import tobyspring.hellospring.api.*;

import java.math.BigDecimal;



public class WebApiExRateProvider implements ExRateProvider {

    private final ApiTemplate apiTemplate;

    public WebApiExRateProvider(ApiTemplate apiTemplate) {
        this.apiTemplate = apiTemplate;
    }


    @Override
    public BigDecimal getExrate(String currency) {
        String url = "https://open.er-api.com/v6/latest/" + currency;

        return apiTemplate.getForExRate(url);
    }
}
