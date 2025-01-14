package com.training.SpringBootPractice.service;

import com.training.SpringBootPractice.model.User;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface UserService {
  List<User> getUsers();

  User createUser(User user);
}
