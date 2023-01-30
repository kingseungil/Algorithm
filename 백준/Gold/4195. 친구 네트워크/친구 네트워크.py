import sys
test_case = int(sys.stdin.readline().strip())

# 루트를 찾아주는 함수 find
def find(x):
    if x == parent[x]:  # 자기 자신이 루트 -> 아직 연결X
        return x
    else:
        # 자신의 부모를 재귀적으로 찾음
        parent[x] = find(parent[x])
        return parent[x]

# 두 집합을 연결해주는 함수 union
def union(x, y):
    x, y = find(x), find(y)

    # 부모 노드를 합쳐서 하나의 집합으로 만들어줌
    if x != y:
        parent[y] = x
        number[x] += number[y]


for _ in range(test_case):
    parent = dict()
    number = dict()
    F = int(sys.stdin.readline().strip())

    for _ in range(F):
        x, y = sys.stdin.readline().split()

        if x not in parent:
            parent[x] = x
            number[x] = 1
        if y not in parent:
            parent[y] = y
            number[y] = 1

        union(x, y)
        print(number[find(x)])
