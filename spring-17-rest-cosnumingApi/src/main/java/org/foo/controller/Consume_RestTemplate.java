package org.foo.controller;

import org.foo.dto.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/")
public class Consume_RestTemplate {
    private final String URI= "https://jsonplaceholder.typicode.com/users ";
    private final RestTemplate template;

    public Consume_RestTemplate(RestTemplate template) {
        this.template = template;
    }

    @GetMapping
    public User[] readAllUsers(){
        ResponseEntity<User[]> responseEntity = template.getForEntity(URI,User[].class);

        return responseEntity.getBody();
    }

    @GetMapping("{id}")
    public Object readUserById(@PathVariable("id")Integer id){
        String URL = URI+ "/{id}" ;
        return template.getForObject(URL, Object.class,id);
    }



}
