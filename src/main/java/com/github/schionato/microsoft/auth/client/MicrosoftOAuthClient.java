package com.github.schionato.microsoft.auth.client;

import feign.Feign;
import feign.Headers;
import feign.Param;
import feign.RequestLine;
import feign.form.FormEncoder;
import feign.jackson.JacksonDecoder;

public interface MicrosoftOAuthClient {

    static MicrosoftOAuthClient get() {
        return Feign.builder()
                .encoder(new FormEncoder())
                .decoder(new JacksonDecoder())
                .target(MicrosoftOAuthClient.class, "https://login.microsoftonline.com/common/oauth2/v2.0/");
    }

    @RequestLine("POST /token")
    @Headers("Content-Type: application/x-www-form-urlencoded")
    MicrosoftResponseToken getToken(
            @Param("grant_type") String grantType,
            @Param("redirect_uri") String redirectUrl,
            @Param("client_id") String clientId,
            @Param("client_secret") String clientSecret,
            @Param("code") String code
    );

}
