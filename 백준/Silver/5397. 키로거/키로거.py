testcase = int(input())

for _ in range(testcase):
    stack_left = []
    stack_right = []
    data = input()
    for i in data:
        if i == '<':
            if stack_left:
                stack_right.append(stack_left.pop())
        elif i == '>':
            if stack_right:
                stack_left.append(stack_right.pop())
        elif i == '-':
            if stack_left:
                stack_left.pop()
        else:
            stack_left.append(i)
    stack_left.extend(reversed(stack_right))
    print(''.join(stack_left))
