package com.github.schionato.microsoft.auth;

import com.github.schionato.microsoft.auth.client.MicrosoftOAuthClient;
import com.github.schionato.microsoft.auth.client.MicrosoftRequestToken;
import com.github.schionato.microsoft.auth.client.MicrosoftResponseToken;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/microsoft")
public class MicrosoftController {

    private final MicrosoftOAuthUrl oauthUrl;
    private final MicrosoftRequestToken requestToken;

    public MicrosoftController(MicrosoftOAuthUrl oauthUrl, MicrosoftRequestToken requestToken) {
        this.oauthUrl = oauthUrl;
        this.requestToken = requestToken;
    }

    @CrossOrigin
    @GetMapping(value = "/auth/url", produces = MediaType.TEXT_PLAIN_VALUE)
    public String oauthUrl() {
        return oauthUrl.get();
    }

    @GetMapping("/auth/code")
    public ResponseEntity auth(@RequestParam("code") final String code,
                               @RequestParam("session_state") final String sessionSate) {
        MicrosoftResponseToken response = MicrosoftOAuthClient.get().getToken(
                requestToken.getGrantType(),
                requestToken.getRedirectUri(),
                requestToken.getClientId(),
                requestToken.getClientSecret(),
                code
        );
        return ResponseEntity.status(HttpStatus.FOUND).build();
    }

}
