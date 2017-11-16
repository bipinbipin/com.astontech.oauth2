package com.astontech.oauth2.services;

import com.astontech.oauth2.domain.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Base64;

@Service
public class RestClientService {

    @Autowired
    RequestTokenService requestTokenService;

    final RestTemplate restTemplate = new RestTemplate();
    final String url_unsecured = "http://localhost:8080/api/test/";
    final String url_secured = "http://localhost:8080/api/member/";
    //region getForObject()

    public Member getMemberSingleUnsecured() {
        Member member = restTemplate.getForObject(url_unsecured + "1", Member.class);
        return member;
    }

    public Iterable<Member> getAllMemberUnsecured() {
        Member[] members = restTemplate.getForObject(url_unsecured, Member[].class);
        return Arrays.asList(members);
    }

    //endregion
    //region getForEntity()

    public ResponseEntity<String> getSingleMemberResponse() {
        ResponseEntity<String> response = restTemplate.getForEntity(url_unsecured + "1", String.class);
        return response;
    }

    //endregion

    public ResponseEntity<String> getSingleMemberSecured() {
        HttpEntity<String> entity = new HttpEntity<String>("parameters", buildHeaders());

        return restTemplate.exchange(url_secured, HttpMethod.GET, entity, String.class);
    }


    private HttpHeaders buildHeaders()
    {
        //note:  This will request a new token with call.
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        headers.add("Authorization", "Bearer " + requestTokenService.requestToken().getAccess_token());

        return headers;
    }
}
