import sys

n,c = tuple(map(int, input().split()))
x = list(map(int, input().split()))

#-xj + cj + xi - ci
case1 = -sys.maxsize - 1
#xj + cj - xi - ci
case2 = -sys.maxsize - 1

ans = []

for i in range (n):
    largest = 0
    largest = max(case1 + x[i] - c * i, case2 - x[i] - c * i, largest)
    ans.append(largest)
    case1 = max(case1, -x[i] + c * i)
    case2 = max(case2, x[i] + c * i)

print(" ".join(str(a) for a in ans))
