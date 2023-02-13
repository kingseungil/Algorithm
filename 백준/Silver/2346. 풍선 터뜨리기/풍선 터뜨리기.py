from collections import deque
import sys
input = sys.stdin.readline

N = int(input())  # N = 원소 개수
numbers = list(map(int, input().split()))  # 전체 원소 리스트
# 덱에 (인덱스,값) 형태로 넣어줌
d = deque()
for index, value in enumerate(numbers, start=1):
    d.append((index, value))
result = []  # 터지는 풍선의 번호(인덱스)

# 첫번째 원소 추출
index, current_value = d.popleft()
result.append(index)

for _ in range(N-1):
    # case1. 양수 값일 때
    if current_value > 0:
        # 왼쪽으로 회전
        for _ in range(current_value-1):
            x = d.popleft()
            d.append(x)
    # case2. 음수 값 일때
    else:
        # 오른쪽으로 회전
        for _ in range(-current_value):
            x = d.pop()
            d.appendleft(x)

    # 원소 추출
    index, current_value = d.popleft()
    result.append(index)

for x in result:
    print(x, end=' ')
