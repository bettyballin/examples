import base64
import hashlib
import random

def obfuscate_filename(filename):
    # Convert filename to base64
    base64_string = base64.b64encode(filename.encode()).decode()

    # Apply random rotation
    rotation = random.randint(0, len(base64_string) - 1)
    rotated_string = base64_string[rotation:] + base64_string[:rotation]

    # Truncate to fixed length
    truncated_string = rotated_string[:16]

    # Generate hash
    hash = hashlib.sha256(filename.encode()).hexdigest()

    return truncated_string, hash

# Example usage
filename = "example.txt"
obfuscated_filename, hash_value = obfuscate_filename(filename)
print(f"Obfuscated filename: {obfuscated_filename}")
print(f"Hash: {hash_value}")