package org.example.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApiProviderConfig {

    private String clientId;
    private String redirectUri;
    private String authorizeQuery;
    private String clientSecret;
    private String accessTokenUri;
    private String userinfoUri;
}
