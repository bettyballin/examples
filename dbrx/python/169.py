from random import randrange

def gen_128_bits_entropy():
    return ''.join(hex(randrange(16))[2:].zfill(2) for _ in range(16))

print(gen_128_bits_entropy())