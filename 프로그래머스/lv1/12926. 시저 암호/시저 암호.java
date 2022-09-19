class Solution {
    public String solution(String s, int n) {
        //a(97),A(64),z(122),Z(90)
        String answer = "";
        char FirstC; // a인지 A인지
        char c;
        for(int i=0;i<s.length();i++){
            c=s.charAt(i);
            if(c != ' '){
                // 삼항연산자로 코드간결화
                FirstC = Character.isUpperCase(c) ? 'A' : 'a';
                // 알파벳수가 26개니까 26개안에서만 순환하게 해줌
                c = (char)(FirstC + (c+n-FirstC)%26);
            }
            answer += c;
        }
        return answer;
    }
}