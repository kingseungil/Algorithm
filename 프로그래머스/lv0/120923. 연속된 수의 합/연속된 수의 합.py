def solution(num, total):
    answer = []
    val = (2*total/num+1-num) / 2
    for i in range(num):
        answer.append(val+i)
    return answer