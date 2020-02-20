#use max key = delta fxn
import itertools
n = int(input()) #num observations
t = [input().split() for i in range(n)]
def v(d1,d2,t1,t2):
    return abs((int(d2)-int(d1))/(int(t2)-int(t1)))
c = itertools.combinations(t, 2)
max_v = 0
for i in c:
    if v(i[0][1], i[1][1], i[0][0], i[1][0]) > max_v: max_v = v(i[0][1], i[1][1], i[0][0], i[1][0]) 
print(max_v)