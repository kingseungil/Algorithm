from collections import deque
import sys
input = sys.stdin.readline

N, M = map(int, input().split())  # N=원소 개수, M=뽑아내는 횟수
d = deque([i for i in range(1, N+1)])  # 1부터 N까지 원소 삽입(덱 이용)
targets = list(map(int, input().split()))  # 뽑아낼 원소 목록
cnt = 0  # 회전 연산 수행 횟수

for target in targets:
    index = d.index(target)  # 덱에서 해당 원소의 인덱스 찾기
    # case1. 왼쪽으로 회전시키는게 더 빠른 경우
    if index <= len(d) // 2:
        for i in range(index):
            x = d.popleft()
            d.append(x)
            cnt += 1
    # case2. 오른쪽으로 회전시키는게 더 빠른 경우
    else:
        for i in range(len(d)-index):
            x = d.pop()
            d.appendleft(x)
            cnt += 1

    d.popleft()  # 회전 시킨 후 원소 꺼내줌

print(cnt)
