from cryptography.hazmat.primitives.kdf.pbkdf2 import PBKDF2HMAC
from cryptography.hazmat.backends import default_backend

def check_password(password, hash):
    # Extract salt and iterations from the stored hash
    parts = hash.split('$')
    if len(parts) != 5:
        raise ValueError("Invalid hashed value")

    algorithm, iterations, salt, _ = parts[1:]
    iterations = int(iterations)
    salt = bytes.fromhex(salt)

    kdf = PBKDF2HMAC(
        algorithm=algorithm,
        length=32,
        salt=salt,
        iterations=iterations,
        backend=default_backend()
    )

    try:
        # Verify the password
        return hash == "$pbkdf2-" + algorithm + "$" + str(iterations) + "$" + salt.hex() + "$" + kdf.derive(password.encode()).hex()
    except (TypeError, ValueError):
        raise ValueError("Invalid hashed value")

# Usage example
password = "123456"
hash = "$pbkdf2-sha512$25000$pXROaU2JUSrlnDPm3BsjBA$ckspsls2SWPhl9dY7XDiAZh5yucWq27fWRuVj4aOUc5dA2Ez5VH1LYiz5KjaZJscaJYAFhWIwPhkAsHiPOrvrg"

if check_password(password, hash):
    print("Password is correct")
else:
    print("Invalid password or hashed value")