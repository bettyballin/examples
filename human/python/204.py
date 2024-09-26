from Crypto.Random import random

def generate_auth_token():
    """ Generate a 32-char alnum string. 190 bits of entropy. """
    alnum = ''.join(c for c in map(chr, range(256)) if c.isalnum())
    return ''.join(random.choice(alnum) for _ in range(32))

if __name__ == "__main__":
    print(generate_auth_token())