class Solution {
    public int solution(int slice, int n) {
        int result = 0;
        
        if(slice >= n) {
            result = 1;
        } else {
            result = n / slice;
            if (n % slice != 0) {
                result ++;
            }
        }
        
        return result;
    }
}