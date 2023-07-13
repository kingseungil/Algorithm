class Solution {
    public String solution(int[] numLog) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < numLog.length - 1; i++) {
          int condition = numLog[i + 1] - numLog[i];
          switch (condition) {
            case 1 -> sb.append("w");
            case -1 -> sb.append("s");
            case 10 -> sb.append("d");
            case -10 -> sb.append("a");
          }
        }
        
        return sb.toString();
    }
}