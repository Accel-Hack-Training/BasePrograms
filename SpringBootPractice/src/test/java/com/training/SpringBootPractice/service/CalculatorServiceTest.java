package com.training.SpringBootPractice.service;

import com.training.SpringBootPractice.exception.DivideZeroException;
import com.training.SpringBootPractice.service.impl.CalculatorServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
public class CalculatorServiceTest {
  @Mock CalculatorService calculatorService;

  @Test
  @DisplayName("add")
  public void add() {
    int result = calculatorService.add(1, 2);
    assert(result == 3);
  }

  @Test
  @DisplayName("subtract")
  public void subtract() {
    int result = calculatorService.subtract(2, 1);
    assert(result == 1);
  }

  // Program 1: Implement multiply and divide methods in Calculator.java
  @Test
  @DisplayName("multiply")
  public void multiply() {
    int result = calculatorService.multiply(2, 3);
    assert(result == 6);
  }

  @Test
  @DisplayName("divide")
  public void divide() {
    int result = calculatorService.divide(6, 3);
    assert(result == 2);
  }

  @Test
  @DisplayName("divide by zero")
  public void divideByZero() {
    assertThrows(DivideZeroException.class, () -> calculatorService.divide(6, 0));
  }
}
