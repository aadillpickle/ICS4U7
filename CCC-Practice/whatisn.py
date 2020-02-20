import itertools
n = int(input())

a = [i for i in range(6)]
b = itertools.combinations(a, 2)

c = len([i for i in b if sum(i) == n]) 
if n % 2 == 0:
    c += 1

print(c)
