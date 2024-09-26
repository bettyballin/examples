import hashlib

input_str = "go run hashit.go"
hashed = hashlib.sha1(input_str.encode()).hexdigest()
print(hashed)