

n = int(input())

m = int(input())

s = input()

pn = 'IOI'

i=0
while i<n-1:
    pn += 'OI'
    i+=1
cnt=0
for i in range(m-len(pn)+1):
    if s[i:i+len(pn)] == pn:
        cnt+=1

print(cnt)