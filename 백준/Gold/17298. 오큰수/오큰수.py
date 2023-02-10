import sys
N = int(input())
input = list(map(int, sys.stdin.readline().split()))
NGE = [-1] * N
stack = []

for i in range(N):
    x = input[i]
    if len(stack) == 0 or stack[-1][0] >= x:
        stack.append((x, i))  # (수,인덱스) 형태
    else:
        while len(stack) > 0:
            pre, index = stack.pop()  # 역방향으로 하나씩 pop
            if pre >= x:  # 크거나 같은 이전 원소를 만났으면 다시 삽입
                stack.append((pre, index))
                break
            else:
                NGE[index] = x
        stack.append((x, i))

for x in NGE:
    print(x, end=' ')
