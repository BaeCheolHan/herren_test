package com.herren.question;

import com.herren.exception.HerrenException;
import com.herren.utils.TestUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.LongAdder;
import java.util.stream.Collectors;

public class NumberCombination implements Question {

  private final String target;
  private final LongAdder counter;
  private final List<List<Integer>> resultList;

  public NumberCombination(String target) {
    if (target == null || target.isEmpty()) {
      throw new HerrenException("빈문자열은 처리할 수 없습니다.");
    }
    this.target = target;
    counter = new LongAdder();
    resultList = new ArrayList<>();
  }

  @Override
  public void solve() {
    List<Integer> numberList = TestUtils.extractNumber(target);
    Collections.sort(numberList);
    boolean[] visited = new boolean[numberList.size()];
    for (int length = 1; length <= numberList.size(); length++) {
      combination(numberList, visited, 0, numberList.size(), length);
    }

    System.out.println("[NumberCombination]");
    System.out.println(String.format("output %d\n", counter.longValue()));

    String result = resultList
      .stream()
      .map(e -> e.stream().map(String::valueOf).collect(Collectors.joining(",", "", "")))
      .collect(Collectors.joining(" / ", "(", ")"));
    System.out.println(result);
  }

  private void combination(List<Integer> numberList, boolean[] visited, int start, int elemLength, int length) {
    if (length == 0) {
      collect(numberList, visited, elemLength);
      return;
    }

    for (int i = start; i < elemLength; i++) {
      visited[i] = true;
      combination(numberList, visited, i + 1, elemLength, length - 1);
      visited[i] = false;
    }
  }

  private void collect(List<Integer> lst, boolean[] visited, int elemLength) {

    List<Integer> result = new ArrayList<>();
    for (int i = 0; i < elemLength; i++) {
      if (visited[i]) {
        result.add(lst.get(i));
      }
    }

    if (result.stream().mapToInt(e -> e).sum() == 10) {
      counter.increment();
      resultList.add(result);
    }

  }
}
