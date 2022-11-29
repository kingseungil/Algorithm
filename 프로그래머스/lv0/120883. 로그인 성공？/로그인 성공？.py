def solution(id_pw, db):
    for i in db:
        if id_pw[0] in i and id_pw[1] in i:
            return 'login'
        elif id_pw[0] in i and id_pw[1] not in i:
            return 'wrong pw'
    return 'fail'
            
    
        
    
    