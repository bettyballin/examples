class WordArray:
    def __init__(self, words, sigBytes):
        self.words = words
        self.sigBytes = sigBytes

class CryptoJS:
    class enc:
        class u8array:
            @staticmethod
            def stringify(wordArray):
                words = wordArray.words
                sigBytes = wordArray.sigBytes
                u8 = bytearray(sigBytes)
                for i in range(sigBytes):
                    byte = (words[i >> 2] >> (24 - (i % 4) * 8)) & 0xff
                    u8[i] = byte
                return u8

            @staticmethod
            def parse(u8arr):
                len_u8arr = len(u8arr)
                words = [0] * ((len_u8arr + 3) // 4)
                for i in range(len_u8arr):
                    words[i >> 2] |= (u8arr[i] & 0xff) << (24 - (i % 4) * 8)
                return WordArray(words, len_u8arr)

# Example usage:
word_array = WordArray([0x12345678, 0x90abcdef], 8)
u8arr = CryptoJS.enc.u8array.stringify(word_array)
print(u8arr)

parsed_word_array = CryptoJS.enc.u8array.parse(u8arr)
print(parsed_word_array.words)