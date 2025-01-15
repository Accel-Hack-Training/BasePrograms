package com.training.SpringBootPractice.service;

import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.training.SpringBootPractice.model.User;
import com.training.SpringBootPractice.repository.UserRepository;
import com.training.SpringBootPractice.service.impl.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {
  @InjectMocks private UserServiceImpl userService;
  @Mock private UserRepository userRepository;

  @Test
  @DatabaseSetup(value = "/database/testdata")
  public void getUserList() {
    final var expected = List.of(
      User.builder().name("admin").build(),
      User.builder().name("owner").build(),
      User.builder().name("student1").build()
      );
    when(userRepository.findAll()).thenReturn(expected);
    final var actual = userService.getUsers();

    assert(actual.size() == 3);
    for (int i = 0; i < 3; i++) {
      assert(actual.get(i).getName().equals(expected.get(i).getName()));
    }
  }

  @Test
  @DatabaseSetup(value = "/database/testdata")
  public void getUserById() {
    // FIXME: Implement this method
  }

  @Test
  public void createUser() {
    final var expected = User.builder().name("admin").build();
    when(userRepository.save(expected)).thenReturn(expected);
    final var actual = userService.createUser(expected);

    assert(actual.getName().equals(expected.getName()));
  }

  @Test
  public void updateUser() {
    // FIXME: Implement this method
  }

  @Test
  public void deleteUser() {
    final var deleted = User.builder().id(1L).name("admin").build();
    userService.deleteUser(deleted.getId());
    assert(true);
  }

}
