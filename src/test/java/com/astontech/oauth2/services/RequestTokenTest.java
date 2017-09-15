package com.astontech.oauth2.services;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RequestTokenTest {

    @Autowired
    private RequestTokenService requestTokenService;

    @Test
    public void requestToken() {
        System.out.println(requestTokenService.requestToken());

    }

}
