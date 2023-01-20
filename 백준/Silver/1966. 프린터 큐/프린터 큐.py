import sys
test_case = int(sys.stdin.readline().rstrip())

for _ in range(test_case):
    n, m = list(map(int, sys.stdin.readline().split(' ')))
    queue = list(map(int, sys.stdin.readline().split(' ')))
    queue = [(idx, value) for idx, value in enumerate(queue)]
    result = 0

    while True:
        if queue[0][1] == max(queue, key=lambda x: x[1])[1]:
            result += 1
            if queue[0][0] == m:
                print(result)
                break
            else:
                queue.pop(0)
        else:
            queue.append(queue.pop(0))
