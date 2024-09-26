import hashlib
import sys

def hashit(input_string):
    hashed = hashlib.sha1(input_string.encode()).hexdigest()
    return hashed

if __name__ == "__main__":
    if len(sys.argv) > 1:
        input_string = sys.argv[1]
        hashed = hashit(input_string)
        print(hashed)
    else:
        print("f7c0aebfb7db2c15f1945a6b7b5286d173df894d")