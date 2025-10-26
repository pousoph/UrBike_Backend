package co.edu.unbosque.urbike.bicicletaservice.config;

import co.edu.unbosque.urbike.bicicletaservice.client.TelemetriaClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.client.loadbalancer.reactive.LoadBalancedExchangeFilterFunction;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@Configuration
@EnableSpringDataWebSupport(pageSerializationMode = EnableSpringDataWebSupport.PageSerializationMode.VIA_DTO)
public class WebClientConfig {

    private final LoadBalancedExchangeFilterFunction filter;

    public WebClientConfig(LoadBalancedExchangeFilterFunction filter) {
        this.filter = filter;
    }

    @Bean
    @LoadBalanced
    public WebClient telemetriaWebClient() {
        return WebClient.builder().baseUrl("http://iot-service").filter(filter).build();
    }

    @Bean
    public TelemetriaClient telemetriaClient() {
        HttpServiceProxyFactory httpFactory =
                HttpServiceProxyFactory.builder().exchangeAdapter(WebClientAdapter.create(telemetriaWebClient())).build();

        return httpFactory.createClient(TelemetriaClient.class);
    }
}
