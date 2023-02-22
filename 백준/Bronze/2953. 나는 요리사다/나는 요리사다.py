import sys
input = sys.stdin.readline

winner = 0  # 최종 우승자
total_value = 0  # 우승자 점수

for i in range(1, 6):
    row = list(map(int, input().split()))
    value = sum(row)
    if total_value < value:
        total_value = value
        winner = i

print(winner, total_value)
