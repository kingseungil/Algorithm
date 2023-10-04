import java.util.*;

class Solution {
    public String solution(String s) {
        char[] chars = s.toCharArray();
        ArrayList<Character> list = new ArrayList<>();
        for (char c : chars) {
            list.add(c);
        }
        list.sort((o1, o2) -> o2 - o1); // 내림차순 정렬

        StringBuilder sb = new StringBuilder();
        for (Character character : list) {
            sb.append(character);
        }
        return sb.toString();
    }
}