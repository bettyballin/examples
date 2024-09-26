import math

n = 4294967296
sqrt_n = math.sqrt(n)
collision_avg = math.sqrt(n / 2)

print(f"n = {n}, sqrt(n) = {sqrt_n}")
print(f"on average, with a 4 byte token, a collision occurs after {collision_avg:.2f} values")