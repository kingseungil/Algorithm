class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2]; // [0] : 이진 변환 횟수 [1] : 제거된 0의 개수

        while (!s.equals("1")) {
            int count = 0; // 0 제거 후 남은 1의 개수
            for (char c : s.toCharArray()) {
                if (c == '0') {
                    answer[1]++;
                    continue;
                }
                count++;
            }
            s = Integer.toBinaryString(count); // 남은 1의 개수를 이진수로 변환
            answer[0]++;
        }
        return answer;
    }
}