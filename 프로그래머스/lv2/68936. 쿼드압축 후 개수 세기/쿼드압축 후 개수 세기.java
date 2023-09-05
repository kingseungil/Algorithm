import java.util.Arrays;

/*
https://programmers.co.kr/learn/courses/30/lessons/68936 (쿼드압축 후 개수 세기)
 */
public class Solution {

    public static void main(String[] args) {
        int[][] arr = {
          {1, 1, 0, 0},
          {1, 0, 0, 0},
          {1, 0, 0, 1},
          {1, 1, 1, 1}
        };

        int[] result = solution(arr);
        System.out.println(Arrays.toString(result));
    }

    public static int[] solution(int[][] arr) {
        Count count = count(0, 0, arr.length, arr);
        return new int[]{count.zero, count.one};
    }

    private static class Count {

        public final int zero; // 0의 개수
        public final int one; // 1의 개수

        public Count(int zero, int one) {
            this.zero = zero;
            this.one = one;
        }

        // 두 Count 객체를 더한 Count 객체를 반환
        public Count add(Count other) {
            return new Count(this.zero + other.zero, this.one + other.one);
        }
    }

    // arr 배열의 (offsetX, offsetY) 위치에서 시작하는 size 크기의 정사각형을 압축한 결과를 반환
    private static Count count(int offsetX, int offsetY, int size, int[][] arr) {
        int h = size / 2;
        for (int x = offsetX; x < offsetX + size; x++) {
            for (int y = offsetY; y < offsetY + size; y++) {
                // (offsetX, offsetY) 위치에서 시작하는 size 크기의 정사각형에 0과 1이 섞여있으면
                if (arr[y][x] != arr[offsetY][offsetX]) {
                    // 정사각형을 4등분하여 재귀적으로 압축한 결과를 반환
                    return count(offsetX, offsetY, h, arr) // 왼쪽 위
                                                           .add(count(offsetX + h, offsetY, h,
                                                             arr)) // 오른쪽 위
                                                           .add(count(offsetX, offsetY + h, h,
                                                             arr)) // 왼쪽 아래
                                                           .add(count(offsetX + h, offsetY + h, h,
                                                             arr)); // 오른쪽 아래
                }
            }
        }
        if (arr[offsetY][offsetX] == 1) { // 정사각형에 1이 하나라도 있으면
            return new Count(0, 1);
        }
        // 정사각형에 0만 있으면
        return new Count(1, 0);
    }
}
