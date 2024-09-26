def find_r_s(n):
    r = (n - 1) // 2
    s = 1
    while r % 2 == 0:
        s += 1
        r //= 2
    return r, s

n = int(input("Enter a number: "))
r, s = find_r_s(n)
print("r =", r)
print("s =", s)