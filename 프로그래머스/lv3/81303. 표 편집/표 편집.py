def solution(n, k, cmd):
    table = {i : [i-1, i+1] for i in range(n)}
    table[0] = [None, 1]
    table[n-1] = [n-2, None]
    curr_pos = k
    z_stack = []
    for curr_cmd in cmd:
        if curr_cmd == 'C':
            prev, next = table[curr_pos]
            z_stack.append((curr_pos, table[curr_pos]))
            table[prev][1] = next
            table[next][0] = prev
            if next != None:
                curr_pos = next
            else :
                curr_pos = prev
        elif curr_cmd == 'Z':
            input_pos, input_table = z_stack.pop()
            prev, next = input_table
            table[prev][1] = input_pos
            table[next][0] = input_pos
        else :
            datas =curr_cmd.split()
            dist = int(datas[1])
            if datas[0] == 'U':
                while dist != 0:
                    curr_pos = table[curr_pos][0]
                    dist -= 1
            else :
                while dist != 0:
                    curr_pos = table[curr_pos][1]
                    dist -= 1
    answer = ''
    for i in range(n):
        if i in table:
            answer += 'O'
        else :
            answer += 'X'

    return answer