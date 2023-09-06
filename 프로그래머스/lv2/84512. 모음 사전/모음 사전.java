import java.util.ArrayList;

class Solution {
    private static final char[] ALPHABET = "AEIOU".toCharArray();
    private static final int[] POWERS_OF_FIVE = {781, 156, 31, 6, 1};

    public static int solution(String word) {
        int answer = 0;

        for (int i = 0; i < word.length(); i++) {
            for (int j = 0; j < 5; j++) {
                if (ALPHABET[j] == word.charAt(i)) {
                    answer += 1 + j * POWERS_OF_FIVE[i];
                    break;
                }
            }
        }

        return answer;
    }
}