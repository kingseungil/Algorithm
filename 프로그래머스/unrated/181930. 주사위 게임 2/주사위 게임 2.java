class Solution {
    public int solution(int a, int b, int c) {
        int answer = 0;
        // 숫자가 다 다르면
        if (a != b && b != c && c != a) {
          answer = a + b + c;
        }
        // 두 숫자는 같고 나머지 하나는 다르면
        if ((a == b && b != c) || (b == c && c != a) || (c == a && a != b)) {
          answer = (a + b + c) * ((a * a) + (b * b) + (c * c));
        }
        // 모두 같으면
        if (a == b && b == c) {
          answer =
              (a + b + c) * ((a * a) + (b * b) + (c * c)) * ((a * a * a) + (b * b * b) + (c * c * c));
        }
        
        return answer;
    }
}