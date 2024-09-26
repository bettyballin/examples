from Crypto.Cipher import DES
import binascii

def main():
    key = input('Enter your key (8 bytes long): ').encode('utf-8')
    if len(key) != 8:
        print("Key must be 8 bytes long.")
        return

    myDes = DES.new(key, DES.MODE_ECB)
    print('Please select option:\n1. Encryption\n2. Decryption\n3. Exit')

    while True:
        user_choice = input("Choose an option: ")
        if user_choice == "1":
            plain_text = input("Please enter your text: ")
            if len(plain_text) % 8 != 0:
                print("Text must be a multiple of 8 bytes long.")
                continue
            cipher_text = myDes.encrypt(plain_text.encode("utf-8"))
            print("Encrypted text:", cipher_text.hex())

        elif user_choice == "2":
            user_cipher_text = input("Please enter your cipher text: ")
            if len(user_cipher_text) % 16 != 0:
                print("Cipher text must be a multiple of 16 characters long.")
                continue
            try:
                text = myDes.decrypt(binascii.unhexlify(user_cipher_text))
                print("Decrypted text:", text.decode('utf-8'))
            except binascii.Error:
                print("Invalid cipher text.")

        elif user_choice == "3":
            print("Quitting The Program....")
            break
        else:
            print("Please Choose a correct option")

if __name__ == "__main__":
    main()