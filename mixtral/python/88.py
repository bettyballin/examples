# Define a mapping of characters
mapping = str.maketrans('ABC', 'ZYX')

user_input = input("Enter your text: ")
encrypted_text = user_input.translate(mapping)

print("Encrypted Text:", encrypted_text)