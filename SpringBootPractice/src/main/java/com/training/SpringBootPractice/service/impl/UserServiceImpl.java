package com.training.SpringBootPractice.service.impl;

import com.training.SpringBootPractice.model.User;
import com.training.SpringBootPractice.repository.UserRepository;
import com.training.SpringBootPractice.service.UserService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
  private final UserRepository userRepository;

  @Override
  public List<User> getUsers() {
    return userRepository.findAll();
  }

  @Override
  public User createUser(User user) {
    return userRepository.save(user);
  }
}
