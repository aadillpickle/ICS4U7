n = int(input())

sw = [i for i in input().split()]
se = [i for i in input().split()]

s_sw = 0
s_se = 0
d = []

for i in range(n):
    s_sw += int(sw[i])
    s_se += int(se[i])

    if s_sw == s_se:
        d.append((i+1, s_sw))
k = 0
if d != []:
    k = d[len(d)-1][0] 

print(k)