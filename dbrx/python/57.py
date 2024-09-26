from Crypto.Util.number import getPrime

def egcd(a, b):
    if a == 0:
        return (b, 0, 1)
    else:
        g, x, y = egcd(b % a, a)
        return (g, y - (b // a) * x, x)

def modinv(a, m):
    gcd, x, _ = egcd(a, m)
    if gcd != 1:
        raise Exception('modular inverse does not exist')
    else:
        return x % m

p = getPrime(1024)
q = getPrime(1024) # generate large primes p and q
n = p * q          # calculate modulus n
phi_n = (p - 1) * (q - 1)

e = 5              # public exponent e
d = modinv(e, phi_n)   # private exponent d

# encryption:
m = int.from_bytes(b'Hello World!', 'big')    # message to encrypt
c = pow(m, e, n)       # ciphertext c

# decryption using brute force (only for small values of 'e'):
for i in range(1, 10):
    if (i * e) % phi_n == 1:
        print(f'Found d: {d}')
        break
else:
    raise Exception('Could not find private exponent')

m_decrypted = pow(c, modinv(e, n), n)
print(m_decrypted.to_bytes((m_decrypted.bit_length() + 7) // 8, 'big'))