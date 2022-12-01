def solution(slice, n):
    # 2~10조각
    if n % slice == 0:
        count = n // slice
    else:
        count = n // slice + 1
    
    return count