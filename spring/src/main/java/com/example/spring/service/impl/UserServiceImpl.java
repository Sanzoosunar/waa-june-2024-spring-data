package com.example.spring.service.impl;

import com.example.spring.domain.Address;
import com.example.spring.domain.Review;
import com.example.spring.domain.User;
import com.example.spring.repository.UserRepository;
import com.example.spring.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(()->new NoSuchElementException("User not found"));
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public User update(Long id, User user) {
        Optional<User> optional = userRepository.findById(id);

        if(optional.isPresent()) {
            return userRepository.save(user);
        }
        return user;
    }

    @Override
    public void delete(Long id) {

    }


}
