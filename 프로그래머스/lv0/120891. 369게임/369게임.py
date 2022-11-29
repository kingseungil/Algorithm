def solution(order):
    count = 0
    order_list = list(map(int,str(order)))
    
    if order % 10 == 0:
        return 0
    
    for i in order_list:
        if i % 3 == 0:
            count += 1
    
    return count