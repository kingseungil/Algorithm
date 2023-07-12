class Solution {
    public int solution(int a, int b, int c) {
        int answer = 0;
        // 숫자가 다 다르면
        if (a != b && b != c && c != a) {
          answer = a + b + c;
        }
        // 두 숫자는 같고 나머지 하나는 다르면
        if ((a == b && b != c) || (b == c && c != a) || (c == a && a != b)) {
          answer = (int) ((a + b + c) * (Math.pow(a, 2) + Math.pow(b, 2) + Math.pow(c, 2)));
        }
        // 모두 같으면
        if (a == b && b == c) {
          answer =
              (int) ((a + b + c) * (Math.pow(a, 2) + Math.pow(b, 2) + Math.pow(c, 2)) * (Math.pow(a, 3)
                  + Math.pow(b, 3) + Math.pow(c, 3)));
        }
        
        return answer;
    }
}