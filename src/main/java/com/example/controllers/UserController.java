package com.example.controllers;

import com.example.Model.User;
import com.example.Repo.IUserRepository;
import com.example.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(maxAge = 3600)
public class UserController {
    @Autowired(required=true) private IUserRepository _repository;

    @GetMapping(value = "/users")
    public List<User> getUsers(){
        return _repository.findAll();
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUserById(@PathVariable(value = "id") Long uid) throws ResourceNotFoundException {
        User user = _repository.findById(uid)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + uid));
        return ResponseEntity.ok().body(user);
    }

    @PostMapping("/users/post")
    public User createUser(@Valid @RequestBody User user) {
        return _repository.save(user);
    }

    @PostMapping("/users/verify")
    public ResponseEntity<List<User>> verifyUser(@Valid @RequestBody User user) {
        List<User> u = _repository.find(user.getEmail(),user.getPassword());
        //String existence = u.isEmpty() ? "0" : "1";
        return ResponseEntity.ok().body(u);
    }
}
