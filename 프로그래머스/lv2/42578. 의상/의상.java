import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 0;

        // 인자로 받은 2차원배열에서 의상 종류만 추출하여 set에 저장
        Set<String> kinds = new HashSet<>();

        for (String[] clothe : clothes) {
          kinds.add(clothe[1]);
        }

        // 의상 종류별로 의상의 개수를 저장할 배열
        int[] counts = new int[kinds.size()];
        int index = 0;

        // 의상 종류별로 의상의 개수를 저장
        for (String kind : kinds) {
          for (String[] clothe : clothes) {
            if (kind.equals(clothe[1])) {
              counts[index]++;
            }
          }
          index++;
        }
        
        answer = 1;
        for (int count : counts){
            answer *= (count + 1);
        }
        answer--;
        
        return answer;
    }
}