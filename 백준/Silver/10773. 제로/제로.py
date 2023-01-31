import sys
K = int(input())
stack = []
for _ in range(K):
    input = int(sys.stdin.readline())
    if input == 0:
        stack.pop()
    else:
        stack.append(input)

print(sum(stack))
