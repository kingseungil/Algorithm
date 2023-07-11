import java.util.*;

class Solution {
    public String[] solution(String myStr) {
        
        // a,b,c를 구분자로 사용하여 문자열을 분리
        String[] myArr = myStr.split("[abc]");
        List<String> list = new ArrayList<>(Arrays.asList(myArr));

        // 빈 문자열을 제거
        list.removeIf(String::isEmpty);
        
        
        // EMPTY 예외처리
        if (list.size() == 0) {
          list.add("EMPTY");
        }
        
        // list를 String[]로 변환
        String[] answer = list.toArray(new String[0]);
        
        return answer;
    }
}