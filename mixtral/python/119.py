def ModularMultiplicaiveInverse(e, phi):
    def extended_gcd(a, b):
        if a == 0:
            return b, 0, 1
        else:
            gcd, x, y = extended_gcd(b % a, a)
            return gcd, y - (b // a) * x, x

    gcd, x, y = extended_gcd(e, phi)
    if gcd != 1:
        return None
    else:
        return x % phi

def EncryptCharRSA(msg, p, q, n):
    phi = (p-1) * (q-1)
    cipher_no = ""

    for char in msg:
        # Convert character to ASCII value
        ascii_val = ord(char)

        # Encrypt the number
        encrypted_num = pow(ascii_val, n, phi)

        cipher_no += chr(encrypted_num)

    return cipher_no

def DecryptCharRSA(msg, p, q):
    n = p * q
    phi = (p-1) * (q-1)
    e = ModularMultiplicaiveInverse(phi, (p-1)*(q-1))
    plaintext = ""

    for char in msg:
        # Convert character to ASCII value
        ascii_val = ord(char)

        # Decrypt the number
        decrypted_num = pow(ascii_val, e, n)

        plaintext += chr(decrypted_num)

    return plaintext

# Test the functions
p = 61
q = 53
n = p * q
msg = "Hello, World!"

encrypted_msg = EncryptCharRSA(msg, p, q, n)
print("Encrypted message:", encrypted_msg)

decrypted_msg = DecryptCharRSA(encrypted_msg, p, q)
print("Decrypted message:", decrypted_msg)