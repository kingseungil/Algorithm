import sys
import heapq
input = sys.stdin.readline


def pop(heap):
    while len(heap) > 0:
        data, id = heapq.heappop(heap)
        # 처음 삭제하는 원소라면
        if not deleted[id]:
            deleted[id] = True
            return data
    return None  # 삭제할 원소가 없으면 None 반환


T = int(input())
for _ in range(T):
    k = int(input())
    min_heap = []
    max_heap = []
    cur_id = 0  # 삽입할 원소의 인덱스값
    deleted = [False] * (k+1)  # 각 원소의 삭제여부
    for i in range(k):
        command = input().split()
        op, value = command[0], int(command[1])
        if op == 'D':
            if value == -1:
                pop(min_heap)
            else:
                pop(max_heap)
        else:
            heapq.heappush(min_heap, (value, cur_id))
            heapq.heappush(max_heap, (-value, cur_id))  # 최대힙을 위해 음수로 삽입
            cur_id += 1  # 다음 원소를 위해 인덱스값 증가
    max_value = pop(max_heap)
    if max_value is None:
        print('EMPTY')
    else:
        # 최대힙에서 삭제한 원소를 최소힙에 다시 삽입
        heapq.heappush(min_heap, (-max_value, cur_id))
        print(-max_value, pop(min_heap))
