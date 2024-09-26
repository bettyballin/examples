def encrypt(msg, e, n):
    return pow(msg, e, n)

def decrypt(M, d, n):
    return pow(M, d, n)

# example usage:
if __name__ == "__main__":
    msg = 123
    e = 17
    d = 2753
    n = 323

    encrypted = encrypt(msg, e, n)
    decrypted = decrypt(encrypted, d, n)

    print(f"Original message: {msg}")
    print(f"Encrypted message: {encrypted}")
    print(f"Decrypted message: {decrypted}")