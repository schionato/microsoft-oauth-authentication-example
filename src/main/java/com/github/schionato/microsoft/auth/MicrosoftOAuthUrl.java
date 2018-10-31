package com.github.schionato.microsoft.auth;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
class MicrosoftOAuthUrl {

    private final String microsoftAuthorizeUrl;
    private final String clientId;
    private final String redirectUrl;
    private final String scope;

    MicrosoftOAuthUrl(@Value("${microsoft_oauth_authorize_url}") String microsoftAuthorizeUrl,
                      @Value("${microsoft_oauth_client_id}") String clientId,
                      @Value("${microsoft_oauth_redirect_url}") String redirectUrl,
                      @Value("${microsoft_oauth_scope}") String scope) {
        this.microsoftAuthorizeUrl = microsoftAuthorizeUrl;
        this.clientId = clientId;
        this.redirectUrl = redirectUrl;
        this.scope = scope;
    }

    String get() {
        return String.format(
                "%s?client_id=%s&redirect_uri=%s&response_type=code&scope=%s",
                microsoftAuthorizeUrl, clientId, redirectUrl, scope
        );
    }

}
