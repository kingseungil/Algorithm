class Solution {
    public String solution(String myString, String pat) {
        String answer = "";
        if(myString.contains(pat)){
            answer += myString.substring(0,myString.lastIndexOf(pat)+pat.length());
        }
        return answer;
    }
}