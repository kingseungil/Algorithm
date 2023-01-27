import sys

N = int(sys.stdin.readline().strip())
N_set = set(map(int, sys.stdin.readline().split()))
M = int(sys.stdin.readline().strip())
M_list = list(map(int,sys.stdin.readline().split()))

for i in M_list:
    if i not in N_set:
        print(0)
    else:
        print(1)