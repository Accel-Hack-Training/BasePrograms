package com.training.SpringBootPractice.service;

public interface CalculatorService {
  /**
   * Add two numbers
   * @param a
   * @param b
   * @return sum of a and b
   */
  int add(int a, int b);

  /**
   * Subtract two numbers
   * @param a
   * @param b
   * @return difference of a and b
   */
  int subtract(int a, int b);

  /**
   * Multiply two numbers
   * @param a
   * @param b
   * @return product of a and b
   */
  int multiply(int a, int b);

  /**
   * Divide two numbers
   * @param a
   * @param b
   * @return quotient of a and b
   */
  int divide(int a, int b);
}
