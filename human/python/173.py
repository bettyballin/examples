ciphertext = b'SplitsEvenly'
keylength = 4

blocks = [ciphertext[i:i+keylength] for i in range(0, len(ciphertext), keylength)]
print(blocks)