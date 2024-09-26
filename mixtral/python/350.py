import numpy as np

def generate_pn(length):
    pn_sequence = np.random.randint(2, size=length)
    return ''.join(map(str, pn_sequence))

def xor_encrypt(plaintext, pn_sequence):
    cipher = ""

    plaintext_bits = "{0:b}".format(int.from_bytes(plaintext.encode("big"), 'big'))

    for i in range(len(pn_sequence)):
        if len(cipher) < len(plaintext_bits):
            cipher += str(int(plaintext_bits[i]) ^ int(pn_sequence[i]))

    return bytes.fromhex('0' + hex(int(cipher, 2))[-2:]).decode()

def encrypt(input_string):
    pn = generate_pn(len(input_string) * 8)

    ciphertext = xor_encrypt(input_string, pn).encode('utf-16')

    return ciphertext

# Test the code
input_string = "Hello, World!"
ciphertext = encrypt(input_string)
print(ciphertext)