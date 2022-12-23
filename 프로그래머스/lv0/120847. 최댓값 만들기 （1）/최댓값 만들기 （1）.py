def solution(numbers):
    max = 0
    n = len(numbers)
    numbers.sort()
    max = numbers[n-2] * numbers[n-1]
    return max