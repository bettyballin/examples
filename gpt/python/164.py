
# Correct the loop that calculates r and s
r = (n - 1) // 2
s = 1
while r % 2 == 0:
    r //= 2
    s += 1

