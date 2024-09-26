def modexp(a, b, n):
    result = 1

    while b > 0:
        if (b & 1) == 1:
            result = (result * a) % n

        a = (a ** 2) % n

        # Right shift the bits of 'b'
        b >>= 1

    return result

def RSA(plaintext, p, q):
    encrypted = ''
    decrypted = ''

    n = p * q

    phi = (p - 1) * (q - 1)

    print("Value of the totient function is %d :" % (phi))

    e = int(input("Enter some coprime number for 'e' according to phi: "))

    d = pow(e, -1, phi)

    for letter in plaintext:
        encoding = modexp(ord(letter), e, n)

        encrypted += chr(encoding)

    print("Encrypted version of %s is:\n%s" % (plaintext, ''.join([f'{c}: {chr(c)}' for c in [encrypted[i] for i in range(0, len(encrypted), 2)] if encrypted[i:i+2]])))

    decrypted = ''

    for letter in encrypted:
        decoding = modexp(ord(letter), d, n)

        decrypted += chr(decoding)

    print("Decrypted version of %s is:\n%s" % (encrypted, ''.join([f'{c}: {chr(c)}' for c in [decrypted[i] for i in range(0, len(decrypted), 2)] if decrypted[i:i+2]])))

Name = input("Enter your name : ")
p = int(input('Enter a prime number (p): '))
q = int(input('Enter a prime number (q): '))
RSA(Name, p, q)