def solution(my_string, letter):
    str_to_list = list(my_string)
    list2 = list(my_string)
    
    for i in list2:
        if i == letter:
            str_to_list.remove(letter)
            
    list_to_str = ''.join(map(str,str_to_list))
    
    return list_to_str