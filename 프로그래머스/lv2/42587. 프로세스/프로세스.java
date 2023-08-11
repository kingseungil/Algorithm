import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((n1,n2) -> n2-n1); // 내림차순
        
        for(int priority : priorities){
            pq.offer(priority);
        }
        
        while(!pq.isEmpty()){
            for(int i=0; i<priorities.length; i++){
                // pq.peek() : 현재 가장 높은 우선순위
                if(priorities[i] == pq.peek()){
                    if(i == location){
                        return ++answer;
                    }
                    pq.poll();
                    answer++;
                }
            }
        }
        return answer;
    }
}