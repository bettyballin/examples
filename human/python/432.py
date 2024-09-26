from passlib.hash import sha512_crypt

def main():
    password = 'password'
    hashed_password = sha512_crypt.hash(password)
    print(hashed_password)

if __name__ == "__main__":
    main()