package com.in28minutes.rest.webservices.restfulwebservices.user;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class UserResource {
    private final UserDaoService service;

    public UserResource(UserDaoService service) {
        this.service = service;
    }

    @GetMapping(path = "/users")
    public List<User> retrieveAllUsers() {
        return UserDaoService.findAll();
    }

    @GetMapping(path = "/users/{id}")
    public User retrieveAllUsers(@PathVariable int id) {
        User user = service.findOne(id);
        if(user == null){
            throw new UserNotFoundException("id:" + id);
        }
        return user;
    }

    @PostMapping(path = "users")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User savedUser = service.save(user);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId()).toUri();
        return ResponseEntity.created(location).build();
    }
}
