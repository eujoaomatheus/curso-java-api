package com.estudos.java.cursoapiv1.services;

import com.estudos.java.cursoapiv1.entities.User;
import com.estudos.java.cursoapiv1.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    final
    UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> listar() {

        return userRepository.findAll();
    }

    public User buscarPeloId(Long id) {

        return userRepository.findById(id).orElse(null);
    }

    public User salvar(User user) {

        return userRepository.save(user);
    }
}
