import java.util.ArrayList;

class Solution {
    private static final char[] CHARS = "AEIOU".toCharArray();

    public static int solution(String word) {
        return generateWords("").indexOf(word);
    }
    
    private static ArrayList<String> generateWords(String word) {
        ArrayList<String> words = new ArrayList<>();
        words.add(word);

        if (word.length() == 5) {
            return words;
        }

        for (char c : CHARS) {
            words.addAll(generateWords(word + c));
        }
        return words;
    }
}