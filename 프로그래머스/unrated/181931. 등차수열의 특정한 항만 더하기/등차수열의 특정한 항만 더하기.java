class Solution {
    public int solution(int a, int d, boolean[] included) {
        // 등차수열 생성
        int[] arr = new int[included.length];
        for (int i = 0;i < arr.length;i++){
            arr[i] = a + (i * d);
        }
        
        int sum = 0;
        // included 배열의 true인 인덱스의 arr의 합
        for (int i = 0;i < included.length; i++){
            if(included[i]){
                sum += arr[i];
            }
        }
        
        return sum;
    }
}