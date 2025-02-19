package tobyspring.hellospring.exrate;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.URISyntaxException;
import java.time.LocalDateTime;

public class CachedExRateProvider implements ExRateProvider {
    private final ExRateProvider target;


    private BigDecimal cachedExRate;
    private LocalDateTime cacheExpiryTime;
    public CachedExRateProvider(ExRateProvider target) {
        this.target = target;
    }

    @Override
    public BigDecimal getExrate(String currency) throws IOException, URISyntaxException {
        if (cachedExRate == null || cacheExpiryTime.isBefore(LocalDateTime.now())) {
            cachedExRate = this.target.getExrate(currency);
            cacheExpiryTime = LocalDateTime.now().plusSeconds(3);
            System.out.println("Cached Updated");
        }
        return cachedExRate;
    }
}
