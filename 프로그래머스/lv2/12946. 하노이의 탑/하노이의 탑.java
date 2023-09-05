import java.util.ArrayList;

class Solution {
    public int[][] solution(int n) {
        ArrayList<int[]> list = new ArrayList<>();
        
        hanoi(n,1,2,3,list);
        
        int[][] answer = new int[list.size()][2];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
    
    private static void hanoi(int n, int start, int mid, int end, ArrayList<int[]> list) {
        // 원판이 하나일 경우, 바로 목적지로 이동
        if (n == 1) {
            list.add(new int[]{start, end});
            return;
        }
        
        hanoi(n-1,start,end,mid,list);
        list.add(new int[]{start,end});
        hanoi(n-1,mid,start,end,list);
    }
}