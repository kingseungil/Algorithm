from collections import deque
import sys
input = sys.stdin.readline

N, K = map(int, input().split())
d = deque([i for i in range(1, N+1)])
result = []

for _ in range(N):
    for _ in range(K-1):
        x = d.popleft()
        d.append(x)
    x = d.popleft()
    result .append(x)


print('<', end='')
for i in range(len(result)):
    if i < len(result) - 1:
        print(result[i], end=', ')
    else:  # 마지막 원소
        print(result[i], end='')
print('>')
