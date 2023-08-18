class Solution {
    public int solution(String s) {
        int result = Integer.MAX_VALUE;

    // 문자열을 1개 단위부터 s.length() / 2 + 1개 단위까지 잘라서 압축한다.
    for (int count = 1; count <= s.length() / 2 + 1; count++) {
      StringBuilder sb = new StringBuilder();
      int duplicate = 0;

      // 문자열을 count개 단위로 잘라서 압축한다.
      for (int i = 0; i < s.length(); i += count) {
        String current = s.substring(i, Math.min(i + count, s.length()));
        String next =
          (i + count < s.length()) ? s.substring(i + count, Math.min(i + count + count, s.length()))
            : ""; // 다음 문자열이 없으면 빈 문자열을 넣는다.

        // 현재 문자열과 다음 문자열이 같으면 중복 횟수를 증가시킨다.
        if (current.equals(next)) {
          duplicate++;
        } else {
          // 중복된 문자열이 있었으면
          if (duplicate > 0) {
            sb.append(duplicate + 1); // 중복 횟수를 추가한다.
            sb.append(current); // 중복된 문자열을 추가한다.
            duplicate = 0; // 중복 횟수를 초기화한다.
          } else {
            // 중복된 문자열이 없었으면
            sb.append(current); // 중복된 문자열이 없으면 그냥 추가한다.
          }
        }
      }

      // 마지막 중복된 문자열을 추가한다.
      if (duplicate > 0) {
        sb.append(duplicate + 1);
        sb.append(s.substring(s.length() - count)); // 마지막 중복 추가
      }

      // 최소 길이 업데이트
      if (sb.length() < result) {
        result = sb.length();
      }
    }

    return result;
    }
}