N = int(input())
N_list = list(map(int, input().split()))
M = int(input())
M_list = list(map(int, input().split()))
N_list.sort()

def binary_search(value, start, end):
    if start > end:
        return False
    
    mid = (start + end) // 2
    if N_list[mid] > value:
        return binary_search(value, start, mid - 1)
    elif N_list[mid] < value:
        return binary_search(value, mid + 1, end)
    else:
        return True
        
for item in M_list:
    if binary_search(item, 0, N - 1):
        print (1)
    else:
        print (0)     