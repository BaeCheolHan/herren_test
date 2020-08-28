package com.herren.question;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class NumberSort implements Question {

  private final int size;
  private final List<Integer> target;

  public NumberSort(int size, List<Integer> target) {
    if (size < 1 || target.isEmpty()) {
      throw new IllegalArgumentException(String.format("데이터가 유효하지 않습니다. size[%d] input.length[%d] ", size, target.size()));
    }
    this.size = size;
    this.target = target;
  }

  @Override
  public void solve() {
    System.out.println(String.format("[NumberSort]\n"
        + "size : %d\n"
        + "input : %s",
      size, target));
    System.out.println(String.format("output : %s\n\n",
      quickSort(target)
        .stream()
        .map(Object::toString)
        .collect(Collectors.joining(", "))
      )
    );
  }

  private List<Integer> quickSort(List<Integer> target) {

    if (target.size() <= 1) {
      return target;
    }

    int pivot = target.get(0); //pivot 선택 

    //pivot 보다 작은 값 sort
    List<Integer> smallerSorted = quickSort(
      target.stream()
        .skip(1) //pivot 제거 (이후 두 Stream을 합칠때 가운데 들어감)
        .filter(i -> i >= pivot) //filter the elements >= pivot
        .collect(Collectors.toList())
    );

    // pivot보다 큰 값 sort
    List<Integer> biggerSorted = quickSort(
      target.stream()
        .skip(1) // pivot 제거 (이후 두 Stream을 합칠때 가운데 들어감)
        .filter(i -> i < pivot) //filter the elements < pivot
        .collect(Collectors.toList()));

    //smallerSorted ++ [x] ++ biggerSorted 
    return Stream.concat(Stream.concat(smallerSorted.stream(), Stream.of(pivot)), biggerSorted.stream())
      .collect(Collectors.toList());
  }
}
