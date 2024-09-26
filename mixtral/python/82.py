import hashlib

def generate_hash(input):
    return hashlib.sha256(input.encode()).hexdigest()

input = "myInputString"

hashed_value = generate_hash(input)

print("Hashed value:", hashed_value)