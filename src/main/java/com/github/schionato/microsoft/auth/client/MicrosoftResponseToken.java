package com.github.schionato.microsoft.auth.client;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MicrosoftResponseToken {

    @JsonProperty("token_type")
    private String type;

    @JsonProperty("expires_in")
    private int expires;

    @JsonProperty("access_token")
    private String token;

    @JsonProperty("scope")
    private String scope;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getExpires() {
        return expires;
    }

    public void setExpires(int expires) {
        this.expires = expires;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }
}
