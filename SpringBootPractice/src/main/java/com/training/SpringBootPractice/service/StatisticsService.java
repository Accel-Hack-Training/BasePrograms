package com.training.SpringBootPractice.service;

public interface StatisticsService {
  /**
   * Calculate the average of the given numbers
   * @param numbers
   * @return average of the numbers
   */
  double average(int[] numbers);

  /**
   * Calculate the maximum of the given numbers
   * @param numbers
   * @return maximum of the numbers
   */
  int max(int[] numbers);

  /**
   * Calculate the minimum of the given numbers
   * @param numbers
   * @return minimum of the numbers
   */
  int min(int[] numbers);
}
