package org.foo.controller;

import org.foo.client.EmployeeClient;
import org.foo.client.UserClient;
import org.foo.dto.ResponseWrapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Consume_FeignClient {

    private final UserClient userClient;
    private final EmployeeClient employeeClient;

    public Consume_FeignClient(UserClient userClient, EmployeeClient employeeClient) {
        this.userClient = userClient;
        this.employeeClient = employeeClient;
    }

    @GetMapping("/api/v1/users")
    public ResponseEntity<ResponseWrapper> getUsers(){
        return ResponseEntity
                .ok(new ResponseWrapper("User list retrieved",userClient.getUsers()));
    }

    @GetMapping("/api/v1/employee")
    public ResponseEntity<ResponseWrapper> getEmployee(){
        return ResponseEntity.ok(new ResponseWrapper("Employe retrieved",employeeClient.getEmployee("6298ebfecd0551211fce37a6")));
    }
    @GetMapping("/api/v1/employee/{id}")
    public ResponseEntity<ResponseWrapper> getEmloyer(@PathVariable("id") String id){
        return ResponseEntity.ok(new ResponseWrapper("Employe retrieved" , employeeClient.getEmployee("6298ebfecd0551211fce37a6",id)));
    }
}
