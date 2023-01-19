import sys
N,M = list(map(int, sys.stdin.readline().split(' ')))
data = list(map(int, sys.stdin.readline().split(' ')))
data.sort(reverse=True)
result = 0
length = len(data)
for i in range(0, length):
    for j in range(i+1, length):
        for k in range(j+1, length):
            sum = data[i]+data[j]+data[k]
            if sum <= M:
                result = max(result, sum)
                break

print(result)
        
    