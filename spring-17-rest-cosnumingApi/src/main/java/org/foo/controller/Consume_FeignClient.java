package org.foo.controller;

import org.foo.client.UserClient;
import org.foo.dto.ResponseWrapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Consume_FeignClient {

    private final UserClient userClient;

    public Consume_FeignClient(UserClient userClient) {
        this.userClient = userClient;
    }

    @GetMapping("/api/v1/users")
    public ResponseEntity<ResponseWrapper> getUsers(){
        return ResponseEntity
                .ok(new ResponseWrapper("User list retrieved",userClient.getUsers()));
    }

}