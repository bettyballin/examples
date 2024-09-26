import math

n = 203
e = 5

# Assuming p and q are prime factors of n
p = 7
q = 29

# Bruteforce private key 'd'.
for d in range(1, n-1):
    if math.gcd(e, (p - 1) * (q - 1)) == 1 and (e * d) % ((p - 1) * (q - 1)) == 1:
        # Decrypt the ciphertext (assuming some encrypted_value)
        encrypted_value = 123  # Replace with actual encrypted value
        decrypted_value = pow(encrypted_value, d, n)

        for shift in range(26):
            shifted_decrypted_val = ((decrypted_value + shift) % 256)

            print(chr(shifted_decrypted_val))