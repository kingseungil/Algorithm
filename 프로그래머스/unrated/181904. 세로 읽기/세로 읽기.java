class Solution {
    public String solution(String my_string, int m, int c) {
        StringBuilder result = new StringBuilder();
        
        while (my_string.length() > 0) {
            result.append(my_string.charAt(c-1));
            my_string = my_string.substring(m);
        }
        
        return result.toString();
    }
}