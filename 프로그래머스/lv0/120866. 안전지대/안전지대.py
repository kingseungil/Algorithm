def solution(board):
    answer = 0
    check = [[1 for _ in board[0]] for _ in board]
    for y in range(len(board)):
        for x in range(len(board[0])):
            if board[y][x] == 1:
                for yy in range(y-1, y+2):
                    for xx in range(x-1, x+2):
                        if 0 <= xx < len(board[0]) and 0 <= yy < len(board):
                            check[yy][xx] = 0
    answer = sum(sum(each) for each in check)
    return answer