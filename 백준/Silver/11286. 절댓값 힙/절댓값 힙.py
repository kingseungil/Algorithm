import sys
import heapq
input = sys.stdin.readline

heap = []
n = int(input())
for i in range(n):
    x = int(input())
    if x == 0:  # 삭제 연산이라면
        if len(heap) == 0:  # 힙이 비어있는 경우
            print(0)
        else:  # 힙이 비어있지 않은 경우
            abs_value, origin_value = heapq.heappop(heap)
            print(origin_value)
    else:  # 삽입 연산이라면
        heapq.heappush(heap, (abs(x), x))
