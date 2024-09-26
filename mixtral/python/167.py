from Crypto.Cipher import AES

class AESCipher:
    def _pad(self, s):
        block_size = AES.block_size
        padding_length = (block_size - len(s) % block_size) or block_size

        return s + bytes([padding_length] * padding_length)

    def _unpad(self, padded):
        unpadded = bytearray()

        for i in range(len(padded) - 1, -1, -1):
            if i < len(padded) - padded[i]:
                break

            unpadded.append(padded[i])

        return bytes(unpadded[::-1])

# Example usage:
cipher = AESCipher()
padded_data = cipher._pad(b'Hello, World!')
print(padded_data)

unpadded_data = cipher._unpad(padded_data)
print(unpadded_data)