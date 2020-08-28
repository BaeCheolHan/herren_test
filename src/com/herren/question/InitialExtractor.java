package com.herren.question;

import com.herren.exception.HerrenException;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class InitialExtractor implements Question {

  private static final List<String> KOREAN_INITIAL_LIST = Arrays.asList(
    "ㄱ", "ㄲ", "ㄴ", "ㄷ", "ㄸ",
    "ㄹ", "ㅁ", "ㅂ", "ㅃ", "ㅅ",
    "ㅆ", "ㅇ", "ㅈ", "ㅉ", "ㅊ",
    "ㅋ", "ㅌ", "ㅍ", "ㅎ"
  );
  private final String target;

  public InitialExtractor(String target) {
    if (target == null || target.isEmpty()) {
      throw new HerrenException("빈문자열은 처리할 수 없습니다.");
    }
    this.target = target;
  }

  @Override
  public void solve() {
    String[] split = target.split("");
    if (split.length > 0) {
      StringBuilder result = new StringBuilder();

      Arrays.stream(split)
        .forEach(singleString -> {
          char character = singleString.charAt(0);
          if (!Pattern.matches("^[ㄱ-ㅎ가-힣]*$", singleString)) {
            result.append(singleString);
            return;
          }

          if (character >= 0xAC00) {
            int unicodeVal = character - 0xAC00;
            int initialChar = unicodeVal / (21 * 28);
            result.append(KOREAN_INITIAL_LIST.get(initialChar));
          }
        });

      System.out.println(String.format("[InitialExtractor]\n"
        + "input : %s\n"
        + "output : %s\n\n", target, result)
      );
    }
  }
}
