import math

P = 1  # define P
Q = 2  # define Q
R = 3  # define R

sqrt = ((Q**2 - 4*P*R) % 11)**(1/2)
i = (((-Q + math.isqrt((Q**2 - 4 * P * R))) // (2 * P)) % 11)
j = (((-Q - math.isqrt((Q**2 - 4 * P * R))) // (2 * P)) % 11)

print("i:", i)
print("j:", j)