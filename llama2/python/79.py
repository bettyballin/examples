import os
import random

def generate_password(length=10):
    password = ''
    for i in range(length):
        password += chr(random.randint(33, 126))
    return password

if __name__ == "__main__":
    print(generate_password())