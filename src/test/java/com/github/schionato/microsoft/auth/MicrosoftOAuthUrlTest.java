package com.github.schionato.microsoft.auth;

import com.github.schionato.App;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@ActiveProfiles("test")
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = RANDOM_PORT, classes = App.class)
public class MicrosoftOAuthUrlTest {

    @Autowired
    private MicrosoftOAuthUrl oauthUrl;

    @Test
    public void getUrl() {
        assertEquals("https://login.microsoftonline.com/common/oauth2/v2.0/authorize?" +
                "client_id=abcd-eflg-hijk&" +
                "redirect_uri=http://1.2.3.4:8080/microsoft/auth/code" +
                "&response_type=code" +
                "&scope=openid+User.Read", oauthUrl.get());
    }
}