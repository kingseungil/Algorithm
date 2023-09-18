import java.util.Arrays;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int idx = 0;

        for (int[] command : commands) {
            int[] temp = Arrays.copyOfRange(array, command[0] - 1, command[1]); // Arrays.copyOfRange(배열, 시작인덱스, 끝인덱스)
            Arrays.sort(temp);
            answer[idx++] = temp[command[2] - 1];
        }
        return answer;
    }
}