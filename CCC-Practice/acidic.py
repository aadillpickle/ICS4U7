n = int(input())
r = [int(input()) for i in range(0, n)]
c = [(i, r.count(i)) for i in set(r)];
hf = 0
hfr = []
shf = 0
shfr = []
for i in c:
    if i[1] >= hf:
        hf = i[1]
        hfr.append(i[0])

    elif i[1] >= shf and i[1] < hf:
        shf = i[1]
        shfr.append(i[0])
dif = 0

if len(hfr) == 1 and len(shfr) == 1:
    dif = max([abs(hfr[0] - shfr[0]), abs(shfr[0] - hfr[0])])
elif len(hfr) >= 2:
    dif = max([abs(max(hfr) - min(hfr)), abs(max(hfr) - min(hfr))])
else:
    dif = max([abs(hfr[0] - min(shfr)), abs(max(shfr) - hfr[0]), 
    abs(min(shfr) - hfr[0]), abs(hfr[0] - max(shfr))])

print(dif)