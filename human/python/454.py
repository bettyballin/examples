import secrets

def find_collision(b):
    tokens = set()
    while True:
        token = secrets.token_bytes(b)
        if token in tokens:
            return len(tokens)
        tokens.add(token)

b = 4
samples = 100
l = [find_collision(b) for _ in range(samples)]
avg = sum(l)/len(l)

print(f'n = {2**(b*8)}, sqrt(n) = {2**(b*8/2)}')
print(f'on average, with a {b} byte token, a collision occurs after {avg} values')