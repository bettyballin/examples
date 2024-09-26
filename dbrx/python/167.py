import secrets

def generate_password():
    password = ''.join(secrets.choice('ABCDEFGHJKLMNPRSTUVWXYZ') for _ in range(6))
    return password

if __name__ == "__main__":
    print(generate_password())