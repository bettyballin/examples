
print("QuantumShadow's Caesar Cipher")

# Loop the entire process
while True:
    message = input('Write your message here: ')
    print('The encryption key is: ')
    key = int(input())
    print('Do you want to encrypt or decrypt?')
    mode = input()
    LETTERS = 'ABCDEFGHIJKLMNOPQRSTUVWXYZ'
    translated = ''
    message = message.upper()

    for symbol in message:
        if symbol in LETTERS:
            num = LETTERS.find(symbol)
            if mode == 'encrypt':
                num = num + key
            elif mode == 'decrypt':
                num = num - key

            if num >= len(LETTERS):
                num = num - len(LETTERS)
            elif num < 0:
                num = num + len(LETTERS)

            translated += LETTERS[num]
        else:
            translated += symbol

    print(trans
