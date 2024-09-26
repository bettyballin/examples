import hashlib

def main():
    integer = 0x1234567890abcdef
    digest = hashlib.sha256(integer.to_bytes(8, byteorder='big')).hexdigest()
    print(digest)

if __name__ == "__main__":
    main()