import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int solution(int[][] routes) {
        // 끝 지점 기준으로 오름차순 정렬
        Arrays.sort(routes, Comparator.comparingInt(route -> route[1]));

        int count = 0; 
        int lastCamera = Integer.MIN_VALUE;
        for (int[] route : routes) {
            if (route[0] <= lastCamera && lastCamera <= route[1]) { // 카메라가 이미 설치된 구간에 포함되면, 카메라를 설치할 필요가 없음
                continue;
            }
            lastCamera = route[1]; // 카메라를 설치할 수 있는 구간의 끝 지점에 카메라를 설치
            count++;
        }
        return count;
    }
}