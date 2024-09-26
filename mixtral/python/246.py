import string

def breakSingleByteXOR(ciphertext):
    max_score = 0
    key = 0
    decrypted_message = ""
    for i in range(256):
        message = "".join(chr(ord(c) ^ i) for c in ciphertext)
        score = sum(c in string.ascii_letters + ' ' for c in message)
        if score > max_score:
            max_score = score
            key = i
            decrypted_message = message
    return key, decrypted_message

ciphertext = "1b37373331363f78151b7f2b783431333d78397828372d363c78373e783a393b3736"
key, decrypted_message = breakSingleByteXOR(ciphertext)
print(f"Key: {key}")
decoded_chars = [c if c in string.ascii_letters + ' ' else '\\x00' for c in decrypted_message]
cleaned_msg = "".join([ch for ch in decoded_chars])
print(f"Decrypted message: {cleaned_msg}")