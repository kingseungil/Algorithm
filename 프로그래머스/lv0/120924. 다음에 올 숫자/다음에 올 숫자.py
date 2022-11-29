def solution(common):
    isSequence = common[2] - common[1] == common[1] - common[0]
    if isSequence:
        return common[-1] + common[1] - common[0]
    return common[-1] * (common[1] / common[0])