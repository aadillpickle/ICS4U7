grid_r = int(input())
grid_c = int(input())

c = [input().split() for i in range(grid_r)]


grid = [[(i, x) for i in range(1, grid_r+1)] for x in range(1, grid_c+1)]

start = int(c[0][0]) 
grid_start = grid[0][0] 

end = c[grid_r-1][grid_c-1]

grid_end = grid[grid_r-1][grid_c-1]

position = grid_start 
integer = start

visitedSpots = []
def rerun(start, grid_start, end, grid_end, position, integer, visitedSpots):
    for i in grid:
        for x in i:
            if integer == int(x[0]) * int(x[1]):
                if position not in visitedSpots:
                    visitedSpots.append(position)
                    position = x  
                    if position == grid_end:
                        return "yes"           
                    integer = int(c[x[0]-1][x[1]-1])
                    rerun(start, grid_start, end, grid_end, position, integer, visitedSpots)
                else:
                    continue
    return "no"

print(rerun(start, grid_start, end, grid_end, position, integer, visitedSpots))