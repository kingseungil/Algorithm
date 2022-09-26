class Solution {
   public String[] solution(int n, int[] arr1, int[] arr2) {
       String[] answer = new String[n];
        for (int i = 0; i < n; i++) {
            answer[i] = String.format("%" + n + "s", Integer.toBinaryString(arr1[i] | arr2[i]));
            answer[i] = answer[i].replaceAll("1", "#").replaceAll("0"," ");
        }
      return answer;
   }
}
      
      // 아래처럼 바꾸면 성능이 훨씬 향상됨
      /*
        String[] answer = new String[n];
        String temp;
        for (int i = 0; i < n; i++) {
            temp = String.format("%16s", Integer.toBinaryString(arr1[i] | arr2[i]));
            temp = temp.substring(temp.length()-n);
            temp = temp.replaceAll("1", "#").replaceAll("0"," ");
            answer[i] = temp;
        }
        return answer;
    }
    */

}
