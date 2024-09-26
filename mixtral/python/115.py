import time
import pyperclip as copy2clip

with open("encryption.txt", "w") as f:
    f.write(cipher_text)

print("Encryption data saved to encryption.txt...")

copy2clip.copy(cipher_text)

time.sleep(1)

with open("key.txt", "w") as d:
    d.write(str(key))

print("Key data saved to key.txt and copied to clipboard...")