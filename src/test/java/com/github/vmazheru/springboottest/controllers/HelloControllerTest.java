package com.github.vmazheru.springboottest.controllers;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.github.vmazheru.springboottest.httpclient.HTTPClient;
import com.github.vmazheru.springboottest.model.HelloMessage;

import cl.json.JsonMapper;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class HelloControllerTest {
    
    private static JsonMapper m = JsonMapper.getJsonMapper();
    private static HTTPClient c = HTTPClient.getClient();
    private static final String host = "http://localhost:8080";

    @Test
    public void testHelloMessage() {
        String msg = c.get(host).getBody();
        HelloMessage message = m.fromJson(msg, HelloMessage.class);
        assertNotNull(message.getMessage());
        assertNotNull(message.getTime());
    }
    
}
