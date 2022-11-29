def solution(common):
    c = common
    answer = 0
    # 등비중항으로 판별
    for i in range(0,len(common)):
        if c[i+1] ** 2 == c[i] * c[i+2] and c[i]:    
            answer = c[-1] * (c[i+1] / c[i])
        else:
             answer = c[-1] + (c[i+1] - c[i])
        return answer
    
    
    return answer