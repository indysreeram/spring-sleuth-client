package com.sreeram.sluethclient.resources;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/rest/hello")
public class HelloResource {

    private static final Logger logger = LoggerFactory.getLogger(HelloResource.class);

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping(value="/client")
    public String hello(){
        logger.info("Before Calling the Server");
        String response = restTemplate.getForObject("http://localhost:8081/rest/hello/server",String.class);
        logger.info("After Calling Client");
        return response;
    }
}
