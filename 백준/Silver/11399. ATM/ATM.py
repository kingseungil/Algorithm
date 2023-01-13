import sys
N = int(sys.stdin.readline().rstrip())
P = list(map(int,sys.stdin.readline().split()))
P.sort()

result = 0
for i in range(N):
    for j in range(i+1):
        result += P[j]
print(result)
