package com.astontech.oauth2.services;


import com.astontech.oauth2.domain.Member;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.Map;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RestClientServiceTest {

    @Autowired
    private RestClientService restClientService;

    @Test
    public void getMemberUnsecuredTest() {
        Member testMember = restClientService.getMemberSingleUnsecured();
        System.out.println(testMember);
        assertEquals("Bipin", testMember.getFirstName());
    }

    @Test
    public void getAllMembersUnsecuredTest() {
        Iterable<Member> memberIterable = restClientService.getAllMemberUnsecured();
        System.out.println(memberIterable.toString());
        assertEquals(3, memberIterable.iterator().next().getAccounts().size());
    }

    @Test
    public void getResponseTest() throws IOException{
        ResponseEntity<String> response = restClientService.getSingleMemberResponse();

        // RESPONSE CODE
        assertEquals(HttpStatus.OK, response.getStatusCode());

        // HTTP HEADERS
        HttpHeaders httpHeaders = response.getHeaders();
        Map<String, String> headerMap = httpHeaders.toSingleValueMap();
        headerMap.forEach((k,v) -> {
            System.out.println(k + ": " + v);
        });
//        response.getHeaders().toSingleValueMap().forEach((k,v) -> System.out.println(k + ": " + v));

        // JACKSON
        ObjectMapper mapper = new ObjectMapper();

        // GET JSON OUT OF RESPONSE BODY
        JsonNode root = mapper.readTree(response.getBody());

        // MAP JSON TO JAVA OBJECT
        Member member0 = mapper.treeToValue(root, Member.class);
        System.out.println(member0.toString());

        // ALTERNATIVELY PULL FIELDS BY NAME
        assertEquals("Bipin", root.get("firstName").asText());
        assertEquals("Butala", root.get("lastName").asText());
    }

    @Test
    public void fullTest() {
        System.out.println(restClientService.getSingleMemberSecured());
    }
}
