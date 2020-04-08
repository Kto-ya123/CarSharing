package org.example.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@ConfigurationProperties("oauth2")
@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Configuration
public class ApiServiceConfiguration {

    private ApiProviderConfig facebook;
    private ApiProviderConfig github;
    private ApiProviderConfig google;
}
