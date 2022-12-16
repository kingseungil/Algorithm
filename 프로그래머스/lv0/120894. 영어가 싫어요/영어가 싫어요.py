def solution(numbers):
    num = ["zero", "one", "two", "three", "four",
       "five", "six", "seven", "eight", "nine"]

    num2 = ["0", "1", "2", "3", "4", "5", "6", "7", "8", "9"]


    result = numbers.replace(num[0], num2[0]).replace(num[1], num2[1]).replace(num[2], num2[2]).replace(num[3], num2[3]).replace(num[4], num2[4]).replace(num[5], num2[5]).replace(num[6], num2[6]).replace(num[7], num2[7]).replace(num[8], num2[8]).replace(num[9], num2[9])
    
    return int(result)