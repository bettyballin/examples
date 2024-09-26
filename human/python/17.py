import hashlib

shared_private_key = "ABCDEF"

def create_signature(data):
    return hashlib.sha1((repr(data) + "," + shared_private_key).encode()).hexdigest()

def verify_signature(data, signature):
    return signature == create_signature(data)

# Test the functions
data = "Hello, World!"
signature = create_signature(data)
print("Signature:", signature)
print("Verification:", verify_signature(data, signature))