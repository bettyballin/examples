def rail_fence_cipher(plaintext, key):
    d = {}
    for c in plaintext:
        i = (ord(c) % (2 * key)) - key
        if i < 0:
            i += key
        d[c] = chr(i)
    return d

plaintext = "Hello, World!"
key = 3
print(rail_fence_cipher(plaintext, key))