
def encrypt(input_text):
    # Define the translation table: map each letter to its encrypted letter
    alphabet = 'ABCDEFGHIJKLMNOPQRSTUVWXYZ'
    reversed_alphabet = alphabet[::-1]  # 'ZYXWVUTSRQPONMLKJIHGFEDCBA'
    translation_table = str.maketrans(alphabet + alphabet.lower(), reversed_alphabet + reversed_alphabet.lower())

    # Translate the input text using the translation table
    encrypted_text = input_text.translate(translation_table)
    return encrypted_text

# Example usage:
user_input = input("Enter text to encrypt: ")
encrypted = encrypt(user_input)
print(f"Encrypted text: {encrypted}")

