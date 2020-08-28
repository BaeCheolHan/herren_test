package com.herren;

import java.util.Arrays;
import java.util.List;

import com.herren.question.InitialExtractor;
import com.herren.question.NumberCombination;
import com.herren.question.NumberSort;
import com.herren.question.Question;
import com.herren.utils.TestUtils;

public class Application {

  public static void main(String[] args) {
    int numberSortSize = 5;
    List<Question> testCase = Arrays.asList(
      new NumberSort(
        numberSortSize,
        TestUtils.generateRandomIntegerArray(numberSortSize)
      ),
      new InitialExtractor("우리나라 만세"),
      new NumberCombination("apdkf35k47n1t2")
    );
    testCase.forEach(Question::solve);
  }
}
