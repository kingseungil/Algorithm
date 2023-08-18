class Solution {
    public int solution(String s) {
         int min = s.length(); // 최대 길이는 s.length()이다.

    // 주어진 문자열의 길이의 반 이상까지만 검사 (넘어가면 압축 불가능)
    for (int length = 1; length <= s.length() / 2; length++) {
      int compressedLength = compress(s, length);
      min = Math.min(min, compressedLength);
    }
    return min;
  }

  private static int compress(String source, int length) {
    StringBuilder sb = new StringBuilder();

    String current = source.substring(0, length);
    int countOfCurrent = 1;
    for (int i = length; i < source.length(); i += length) {
      String token = source.substring(i, Math.min(i + length, source.length()));

      // 현재 문자열과 다음 문자열이 같으면 중복 횟수를 증가시킨다.
      if (current.equals(token)) {
        countOfCurrent++;
      } else {
        // 현재 문자열과 다음 문자열이 다르면
        if (countOfCurrent > 1) {
          sb.append(countOfCurrent);
        }
        sb.append(current); // 중복이 아닌 문자열을 추가한다.
        current = token; // 다음 문자열을 현재 문자열로 바꾼다.
        countOfCurrent = 1; // 중복 횟수를 초기화한다.
      }
    }

    // 마지막 문자열 처리
    if (countOfCurrent > 1) {
      sb.append(countOfCurrent);
    }
    sb.append(current);

    return sb.length();
  }
}