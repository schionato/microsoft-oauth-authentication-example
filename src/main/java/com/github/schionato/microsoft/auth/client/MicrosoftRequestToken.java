package com.github.schionato.microsoft.auth.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class MicrosoftRequestToken {

    private String grantType;
    private String redirectUri;
    private String clientId;
    private String clientSecret;

    MicrosoftRequestToken(@Value("${microsoft_oauth_redirect_url}") String redirectUri,
                          @Value("${microsoft_oauth_client_id}") String clientId,
                          @Value("${microsoft_oauth_secret}") String clientSecret) {
        this.grantType = "authorization_code";
        this.redirectUri = redirectUri;
        this.clientId = clientId;
        this.clientSecret = clientSecret;
    }

    public String getGrantType() {
        return grantType;
    }

    public String getRedirectUri() {
        return redirectUri;
    }

    public String getClientId() {
        return clientId;
    }

    public String getClientSecret() {
        return clientSecret;
    }
}
