
def InverseMod(a, m):
    for i in range(1, m):
        if (m * i + 1) % a == 0:
            return (m * i + 1) // a
    raise ValueError('No modular inverse found: These are not co-prime.')

def decryption_keys_aff
