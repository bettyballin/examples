from Crypto.Cipher import AES

class AESUtil:
    @staticmethod
    def _aes_pad(s):
        block_size_bytes = AES.block_size // 8
        padding_length = block_size_bytes - (len(s) % block_size_bytes)
        return s + padding_length * chr(padding_length)

# Example usage:
s = "Hello, World!"
padded_s = AESUtil._aes_pad(s)
print(padded_s)