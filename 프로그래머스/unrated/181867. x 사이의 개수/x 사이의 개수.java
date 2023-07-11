class Solution {
    public int[] solution(String myString) {
        String[] myArray = myString.split("x",-1);
        
        int[] answer = new int[myArray.length];
        for(int i = 0; i < myArray.length; i++){
            answer[i] = myArray[i].length();
        }
        
        return answer;
    }
}