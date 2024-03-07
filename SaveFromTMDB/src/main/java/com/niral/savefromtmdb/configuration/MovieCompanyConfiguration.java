package com.niral.savefromtmdb.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class MovieCompanyConfiguration {
    @Bean
    public WebClient movieCompanyClient() {
        return WebClient.builder().baseUrl("https://api.themoviedb.org/3/company").build();
    }
}
