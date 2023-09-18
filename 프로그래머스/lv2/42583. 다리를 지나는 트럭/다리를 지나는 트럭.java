import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int bridgeWeight = 0;
        Queue<Integer> bridge = new LinkedList<>();
        for (int i = 0; i < bridge_length; i++) { // 다리 길이만큼 0으로 초기화
            bridge.add(0);
        }
        int time = 0;
        int truckIdx = 0;

        while (truckIdx < truck_weights.length) {
            bridgeWeight -= bridge.poll(); // 다리를 건넌 트럭의 무게만큼 다리가 견딜 수 있는 무게에서 빼준다.
            int truckWeight = truck_weights[truckIdx]; // 다음 트럭의 무게

            if (bridgeWeight + truckWeight <= weight) { // 다음 트럭이 다리를 건널 수 있으면
                bridge.add(truckWeight);
                bridgeWeight += truckWeight;
                truckIdx++;
            } else { // 다음 트럭이 다리를 건널 수 없으면
                bridge.add(0);
            }
            time++;
        }

        while (bridgeWeight > 0) { // 마지막 트럭이 다리를 건너는 시간을 더해준다.
            bridgeWeight -= bridge.poll();
            time++;
        }

        return time;
    }
}