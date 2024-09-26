from Crypto.Cipher import DES

def main():
    key = '01234567'
    text = 'abcdefgh'

    des = DES.new(key, DES.MODE_ECB)
    cipher_text = des.encrypt(text)
    print(cipher_text)

    decrypted_text = des.decrypt(cipher_text)
    print(decrypted_text)

if __name__ == "__main__":
    main()