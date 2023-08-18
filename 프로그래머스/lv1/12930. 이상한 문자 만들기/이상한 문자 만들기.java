class Solution {
    public String solution(String s) {
         StringBuilder result = new StringBuilder();

    String[] words = s.split(" ",-1);

    for (String word : words) {
      for (int i = 0; i < word.length(); i++) {
        if (i % 2 == 0) {
          result.append(Character.toUpperCase(word.charAt(i)));
        } else {
          result.append(Character.toLowerCase(word.charAt(i)));
        }
      }
      result.append(" ");
    }
    result.deleteCharAt(result.length() - 1);
    return result.toString();
    }
}