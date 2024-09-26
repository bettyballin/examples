import uuid

def decrypt(cipher):
    # assuming a simple decryption function for demonstration purposes
    return str(uuid.UUID(cipher))

n = 3
cipher = "a214868d-f40b-4184-8089-be57330fcd45"

for i in range(n):
    x = decrypt(cipher)
    cipher = x  # corrected variable assignment

print(cipher)