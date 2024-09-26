import random

def getRandomizedSbox():
    sbox = [[random.randint(0, 255) for _ in range(256)] for _ in range(4)]
    return sbox

def expandKey256(key):
    m = [ord(c) for c in key]
    RS = getRandomizedSbox()
    S = [0] * 4
    s = [[0 for _ in range(4)] for _ in range(4)]  # Initialize s
    for i in range(4):
        for j in range(4):
            for k in range(8):
                s[i][j] += m[k] * RS[j][8 * i + k]
                # s[i][j] &= 0xff
            S[i] += s[i][j] * 2 ** (8 * j)
    for i in range(4):
        print('S{} = {}'.format(i, S[i]))

# Test the function
expandKey256("your_key_here")