package com.herren.utils;

import com.herren.exception.HerrenException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class TestUtils {

  public static List<Integer> generateRandomIntegerArray(int size) {
    try {
      Set<Integer> set = new HashSet<>(size);
      SecureRandom s = SecureRandom.getInstanceStrong();
      while (set.size() < size) {
        set.add(s.nextInt());
      }
      return new ArrayList<>(set);
    } catch (Exception e) {
      throw new HerrenException("Random Integer Array 생성에 실패했습니다.", e);
    }
  }

  public static List<Integer> extractNumber(String target) {
    return Arrays.stream(target.split(""))
      .map(it -> it.charAt(0))
      .filter(Character::isDigit)
      .map(Character::getNumericValue)
      .collect(Collectors.toList());
  }
}
