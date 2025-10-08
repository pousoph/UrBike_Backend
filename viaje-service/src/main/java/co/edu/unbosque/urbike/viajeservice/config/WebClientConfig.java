package co.edu.unbosque.urbike.viajeservice.config;

import co.edu.unbosque.urbike.viajeservice.client.BicicletaClient;
import co.edu.unbosque.urbike.viajeservice.client.UsuarioClient;
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
    private final LoadBalancedExchangeFilterFunction filterFunction;

    public WebClientConfig(LoadBalancedExchangeFilterFunction filterFunction) {
        this.filterFunction = filterFunction;
    }

    @Bean
    @LoadBalanced
    public WebClient bicicletaWebClient() {
        return WebClient.builder().baseUrl("http://bicicleta-service").filter(filterFunction).build();
    }

    @Bean
    public BicicletaClient bicicletaClient() {
        HttpServiceProxyFactory httpFactory =
                HttpServiceProxyFactory.builder().exchangeAdapter(WebClientAdapter.create(bicicletaWebClient())).build();
        return httpFactory.createClient(BicicletaClient.class);
    }

    @Bean
    @LoadBalanced
    public WebClient usuarioWebClient() {
        return WebClient.builder().baseUrl("http://usuario-service").filter(filterFunction).build();
    }

    @Bean
    public UsuarioClient usuarioClient() {
        HttpServiceProxyFactory httpFactory =
                HttpServiceProxyFactory.builder().exchangeAdapter(WebClientAdapter.create(usuarioWebClient())).build();
        return httpFactory.createClient(UsuarioClient.class);
    }

}
