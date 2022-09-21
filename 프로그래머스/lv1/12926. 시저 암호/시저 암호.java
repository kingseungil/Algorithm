class Solution {
     public String solution(String s,int n){
        // a(97),A(64),z(122),Z(90)
        char[] ss = s.toCharArray();
        char FirstC; // a인지 A인지
        for (int i = 0; i < s.length(); i++) {
            if (ss[i] != ' '){
                // 삼항연산자로 코드간결화
                FirstC = Character.isUpperCase(ss[i]) ? 'A' : 'a';
                // 알파벳수가 26개니까 26개안에서만 순환하게 해줌
                ss[i] = (char)(FirstC + (ss[i]+n-FirstC) % 26);
            }
        }
        return new String(ss);
    }
}