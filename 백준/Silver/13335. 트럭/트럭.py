from collections import deque
import sys
input = sys.stdin.readline

N, W, L = map(int, input().split())  # 트럭 수, 다리 길이, 최대 하중
trucks = list(map(int, input().split()))
trucks.reverse()

q = deque()
weight = 0  # 총 무게
time = 0  # 총 소요 시간

while True:
    # 모든 트럭을 처리하면 종료
    if len(trucks) == 0 and weight == 0:
        break
    # 큐가 가득 찬 경우 꺼내기
    if len(q) == W:
        x = q.popleft()
        weight -= x
    # 트럭이 다리에 들어 갈 수 있는 경우
    if len(trucks) > 0 and weight + trucks[-1] <= L:
        q.append(trucks[-1])  # 큐(다리)에 추가
        weight += trucks[-1]  # 무게 반영
        trucks.pop()
    # 트럭이 다리에 못 들어가는 경우
    else:
        q.append(0)
    time += 1

print(time)
