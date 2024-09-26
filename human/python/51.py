import random

class Cipher:
    def __init__(self, key):
        self.key = key

    def encrypt(self, text):
        key_index = 0
        result = ""
        for char in text:
            shift = ord(self.key[key_index % len(self.key)]) - ord('a')
            result += chr((ord(char) - ord('a') + shift + random.randint(1, 25)) % 26 + ord('a'))
            key_index += 1
        return result

    def decrypt(self, text):
        key_index = 0
        result = ""
        for char in text:
            shift = ord(self.key[key_index % len(self.key)]) - ord('a')
            for i in range(1, 26):
                if (ord(char) - ord('a') - shift - i) % 26 == ord('a') - ord('a'):
                    result += chr((ord(char) - ord('a') - shift - i) % 26 + ord('a'))
                    break
            key_index += 1
        return result

x = Cipher("this is key")
print("a" == x.decrypt(x.encrypt("a")))
print("b" == x.decrypt(x.encrypt("b")))
print("c" == x.decrypt(x.encrypt("c")))
print(x.encrypt("a") == x.encrypt("a"))