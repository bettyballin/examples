from Crypto.PublicKey import RSA
from base64 import b64decode

def main():
    key64 = b'MIGJAoGBAJNrHWRFgWLqgzSmLBq2G89exgi/Jk1NWhbFB9gHc9MLORmP3BOCJS9k\
onzT/+Dk1hdZf00JGgZeuJGoXK9PX3CIKQKRQRHpi5e1vmOCrmHN5VMOxGO4d+znJDEbNHOD\
ZR4HzsSdpQ9SGMSx7raJJedEIbr0IP6DgnWgiA7R1mUdAgMBAAE='

    keyDER = b64decode(key64)
    keyPub = RSA.importKey(keyDER)

    print(keyPub)

if __name__ == "__main__":
    main()