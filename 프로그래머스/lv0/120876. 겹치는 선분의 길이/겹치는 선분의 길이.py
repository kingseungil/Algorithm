def get_overlapping_length(line1:list, line2:list):
    if line1[0] > line2[0]:
        line1, line2 = line2, line1 
    
    if line1[1] > line2[0]:
        return min(line1[1], line2[1])-line2[0]
    return 0

def solution(lines):
    # lines의 각 원소의 첫번째 값을 기준으로 오름차순 정렬
    lines.sort(key=lambda x:x[0])
    answer = get_overlapping_length(lines[0],lines[1])
    
    # line1과 line2가 겹치지 않는 경우
    if answer == 0:
        answer += get_overlapping_length(lines[0],lines[2])
        answer += get_overlapping_length(lines[1],lines[2])
    # line1과 line2가 겹치는 경우
    else:
        left = min(lines[0][1], lines[1][1])
        right = max(lines[0][1], lines[1][1])
        tmp = [left, right]
        answer += get_overlapping_length(tmp, lines[2])
    
    return answer