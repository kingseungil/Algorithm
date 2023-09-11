class Solution {
    public int[] solution(int brown, int yellow) {
        for (int w = 3; w <= 5000; w++) { // 가로(노란색 격자 개수가 1이상이니까 가로세로 길이가 최소 3)
            for (int h = 0; h <= w; h++) { // 세로
                int boundary = (w + h - 2) * 2; // 테두리 개수
                int yellowCnt = (w - 2) * (h - 2); // 노란색 격자 개수
                if (boundary == brown && yellowCnt == yellow) {
                    return new int[]{w, h};
                }
            }
        }
        return null;
    }
}