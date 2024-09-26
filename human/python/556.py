import secrets
randValue = "".join(map(str, [secrets.randbits(32) for i in range(4)]))
print(randValue)