import secrets

def nonzero_random_bytes(n):
    while True:
        byte_string = secrets.token_bytes(n)
        if all([b != 0 for b in byte_string]):
            return byte_string

if __name__ == "__main__":
    print(nonzero_random_bytes(16))