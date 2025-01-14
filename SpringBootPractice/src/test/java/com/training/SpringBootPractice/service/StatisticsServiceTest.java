package com.training.SpringBootPractice.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class StatisticsServiceTest {

  @Test
  @DisplayName("average")
  public void average() {
    final var input = new int[] {1, 2, 3, 4, 5};
    final var result = 0;

    // call API and set result to variable

    assert(result == 3.0);
  }

  @Test
  @DisplayName("max")
  public void max() {
    final var input = new int[] {1, 2, 3, 4, 5};
    final var result = 0;

    // call API and set result to variable

    assert(result == 5);
  }

  @Test
  @DisplayName("min")
  public void min() {
    final var input = new int[] {1, 2, 3, 4, 5};
    final var result = 0;

    // call API and set result to variable

    assert(result == 1);
  }
}
