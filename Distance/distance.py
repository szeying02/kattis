n = int(input())
s = []
a = []

for k in range(n):
    i, j = tuple(map(int, input().split()))
    s.append(i)
    a.append(j)

ans = 0
s.sort()
a.sort()

for i in range(n):
    ans += s[i] * i - (n - i - 1) * s[i]
    ans += a[i] * i - (n - i - 1) * a[i]

print(ans)
