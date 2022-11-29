def solution(angle):
    # 예각
    if angle > 0 and angle < 90:
        return 1
    # 직각
    elif angle == 90:
        return 2
    # 둔각
    elif angle > 90 and angle < 180:
        return 3
    # 평각
    else:
        return 4