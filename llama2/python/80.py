import secrets

def generate_password():
    password = ''.join([secrets.choice('23456789abcdefghjklmnopqrstuvwxyz') for _ in range(10)])
    return password

if __name__ == "__main__":
    print(generate_password())