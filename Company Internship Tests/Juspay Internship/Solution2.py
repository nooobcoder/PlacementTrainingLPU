'''
You are given a maze with N cells. Each cell may have multiple entry points but not more than one exit (ie. entry/exit points are unidirectional doors like valves).

The cells are named with an integer value from 0 to N-1.

You have to find:

Nearest meeting cell: Given any two cells - C1, C2, find the closest cell Cm that can be reached from both C1 and C2. 


Function Description:

You are given a function Solution containing arr[N], src, desc as inputs. Complete the code in the function and return the answer from it.
'''


def meet(edges, c):

    startCell = c[0]
    c1_cells = []
    cell = startCell
    while cell > -1 and cell not in c1_cells:
        c1_cells.append(cell)
        cell = edges[cell]

    startCell = c[1]
    c2_cells = []
    cell = startCell
    while cell > -1 and cell not in c2_cells:
        c2_cells.append(cell)
        cell = edges[cell]

    min_dist = 999
    ans = -1

    for j in c1_cells:
        if j in c2_cells:
            dist = max(c1_cells.index(j), c2_cells.index(j))
            if dist < min_dist:
                min_dist = dist
                ans = j
    return ans


t = int(input())
for i in range(t):
    size = int(input())
    edges = []
    a_string = input()
    a_list = a_string.split()
    map_object = map(int, a_list)

    list_of_integers = list(map_object)
    # print(list_of_integers)
    for j in list_of_integers:
        edges.append(j)

    c = input()
    c = c.split()
    map_object = map(int, c)

    c = list(map_object)
    print(meet(edges, c))
