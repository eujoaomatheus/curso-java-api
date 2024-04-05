package com.estudos.java.cursoapiv1.controllers;

import com.estudos.java.cursoapiv1.entities.User;
import com.estudos.java.cursoapiv1.services.UserService;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {

    final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<User>> listar() {
        return new ResponseEntity<>(userService.listar(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> buscarPeloId(@PathVariable Long id) {
        User user = userService.buscarPeloId(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<User> salvar(@RequestBody User user) {
        User usuario = userService.salvar(user);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
}
