def encrypt_decrypt():
    while True:
        action = input("Do you want to (E)ncrypt or (D)ecrypt a message? ").upper()
        if action.startswith("E"):
            message = input("Enter the message to encrypt: ")
            shift = int(input("Enter the shift value: "))
            encrypted_message = ""
            for char in message:
                if char.isalpha():
                    ascii_offset = 65 if char.isupper() else 97
                    encrypted_char = chr((ord(char) - ascii_offset + shift) % 26 + ascii_offset)
                    encrypted_message += encrypted_char
                else:
                    encrypted_message += char
            print(f"Encrypted message: {encrypted_message}")
        elif action.startswith("D"):
            message = input("Enter the message to decrypt: ")
            shift = int(input("Enter the shift value: "))
            decrypted_message = ""
            for char in message:
                if char.isalpha():
                    ascii_offset = 65 if char.isupper() else 97
                    decrypted_char = chr((ord(char) - ascii_offset - shift) % 26 + ascii_offset)
                    decrypted_message += decrypted_char
                else:
                    decrypted_message += char
            print(f"Decrypted message: {decrypted_message}")
        else:
            print("Invalid action. Please choose (E)ncrypt or (D)ecrypt.")
        
        if not input("Do you want to encrypt or decrypt another message [y/n]? ").lower().startswith("y"):
            break

encrypt_decrypt()
print("Coded with Python by QuantumShadow.")