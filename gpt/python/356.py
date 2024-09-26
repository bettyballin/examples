
elif user_choice == "2":
    user_cipher_text = input("Please enter your cipher text: ")
    # Assuming the cipher text is in hexadecimal form
    user_cipher_text = bytes.fromhex(user_cipher_text)
    decrypted_text = myDes.decrypt(user_cipher_text)
    print(f"Decrypted text: {decrypted_text.decode('utf-8').rstrip()}")  # Assuming padding is spaces

