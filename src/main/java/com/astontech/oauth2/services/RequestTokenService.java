package com.astontech.oauth2.services;

import com.astontech.oauth2.domain.Member;
import com.astontech.oauth2.domain.OAuthResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import sun.misc.BASE64Encoder;

import java.util.Base64;

@Service
public class RequestTokenService {

    //region NOTES
    /*
        CREATE THE REQUEST FOR A TOKEN

            A) BUILD HEADER
                i) Content-Type (must be "x-www-form-urlencoded")
                ii) Base64 encoded basic authentication

            B) BUILD BODY
                i) needs to be MultiValueMap<String, String> (for urlencoded)
                ii) needs 4 parameters (client_id, username, password, grant_type)

            C) DEFINE JAVA OBJECT TO HOLD RESPONSE
                i) contains (access_token, token_type, refresh_token, expires_in, scope)
     */
    //endregion

    final private RestTemplate restTemplate = new RestTemplate();

    @Value("${aston.oauth.client.url:http://localhost:8080/oauth/token}")
    private String token_request_url;
    @Value("${aston.oauth.client.client_id:aston}")
    private String client_id;
    @Value("${aston.oauth.client.client_secret:secret}")
    private String client_secret;
    @Value("${aston.oauth.client.username:user}")
    private String username;
    @Value("${aston.oauth.client.password:user}")
    private String password;
    @Value("${aston.oauth.client.grant_type:password}")
    private String grant_type;

    public OAuthResponse requestToken() {
        //todo: check for a valid token before requesting a new one.
        return restTemplate.postForObject(token_request_url, createHttpEntity(), OAuthResponse.class);
        //todo: store token returned by Auth server along with Expires time
    }

    private HttpEntity<MultiValueMap<String, String>> createHttpEntity() {
        return new HttpEntity<MultiValueMap<String, String>>(buildBody(), buildHeaders());
    }

    private MultiValueMap<String, String> buildBody() {
        MultiValueMap<String, String> map= new LinkedMultiValueMap<String, String>();
        map.add("client_id", client_id);
        map.add("username", username);
        map.add("password", password);
        map.add("grant_type", grant_type);
        return map;
    }


    private HttpHeaders buildHeaders()
    {
        String creds = client_id + ":" + client_secret;
        String encodedCreds = Base64.getEncoder().encodeToString(creds.getBytes());

        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        headers.add("Content-Type", "application/x-www-form-urlencoded");
        headers.add("Authorization", "Basic " + encodedCreds);

        return headers;
    }
}
