from itertools import zip_longest

def grouper(n, iterable, fillvalue=None):
    "s -> (s0, s1...sn-1), (sn, sn+1...s2n-1), (s2n, s2n+1...s3n-1), ..."
    return zip_longest(*[iter(iterable)]*n, fillvalue=fillvalue)

aes_key = b'\x80in\xbe\x06b\x8f\x8fZ}l-\xb4j\xb5\x1f'

ints = list(aes_key)
print(ints)

tuples = list(grouper(3, aes_key, fillvalue=0))
print(tuples)

tuples = list(grouper(4, aes_key, fillvalue=0))
print(tuples)

if __name__ == "__main__":
    pass