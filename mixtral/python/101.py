print('QuantumShadow\'s Caesar Cipher')
while True:
    message = input('Write your message here: ')

    print('The encryption key is: ')
    key = int(input())

    print('Do you want to encrypt or decrypt? (encrypt/decrypt)')
    mode = input()

    LETTERS = 'ABCDEFGHIJKLMNOPQRSTUVWXYZ'

    translated = ''

    message = message.upper()

    for symbol in message:
        if symbol in LETTERS:
            num = LETTERS.find(symbol)

            if mode == 'encrypt':
                num += key

            elif mode == 'decrypt':
                num -= key

            if num >= len(LETTERS):
                num %= len(LETTERS)

            translated = translated + LETTERS[num]

        else:

            translated = translated + symbol

    print(translated)

    print('Do you want to encrypt/decrypt another message? (yes/no)')

    if input() != 'yes':

        break

print("Code'd with Python by QuantumShadow.")