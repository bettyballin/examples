key = "testtest12"
mapping = list(range(256))

keylen = len(key)
maplen = len(mapping)

for i, v in enumerate(mapping):
    c = ord(key[i % keylen])
    t = (i + c) % maplen
    mapping[i] = mapping[t]
    mapping[t] = v

print(mapping)