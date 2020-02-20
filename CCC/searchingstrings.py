import itertools
n = str(input())
h = str(input())

p = set(itertools.permutations(n, len(n)))
c = 0

for i in p:
    if ''.join(i) in h:
        c+=1

print(c)
