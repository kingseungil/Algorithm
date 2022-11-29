from itertools import permutations
def solution(babbling):
    # aya, ye, woo, ma
    count = 0
    speak = ["aya","ye","woo","ma"]
    word = []
    
    for i in range(1,len(speak)+1):
        for j in permutations(speak,i):
            word.append(''.join(j))
            
    for i in babbling:
        if i in word:
            count += 1
    
    return count