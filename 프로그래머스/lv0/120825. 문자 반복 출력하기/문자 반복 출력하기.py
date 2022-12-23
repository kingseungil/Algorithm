def solution(my_string, n):
    str_list = list(my_string)
    result = list(map(lambda x:x*n,str_list))
    
    return ''.join(result)