
# Assuming b, k, and p are given and you want to compute m = (b**(-k) * a) % p

# Step 1: Compute the modular inverse of b^k modulo p
modular_inverse = pow(b, -k, p)

# Step 2: Multiply a by the modular inverse and take modulo p
m = (modular_inverse * a) % p

print(m)

