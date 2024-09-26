import secrets

def generate_token(length):
    alphabet = '0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz'

    return ''.join([secrets.choice(alphabet) for _ in range(length)]).encode('utf-8')

if __name__ == "__main__":
    length = int(input("Enter token length: "))
    token = generate_token(length)
    print(f"Generated token: {token.decode('utf-8')}")