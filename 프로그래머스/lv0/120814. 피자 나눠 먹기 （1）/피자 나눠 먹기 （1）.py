def solution(n):
    count = 0
    
    if n % 7 == 0:
        count = (n // 7)
    else:
        count = (n // 7) + 1
    
    return count