package com.training.SpringBootPractice.service;

import com.training.SpringBootPractice.model.User;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public interface UserService {
  List<User> getUsers();

  Optional<User> getUserById(Long id);

  User createUser(User user);

  User updateUser(User user);

  void deleteUser(Long id);
}
