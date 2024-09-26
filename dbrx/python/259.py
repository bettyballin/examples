from Crypto.Cipher import AES
import base64

def decrypt_aes_cbc(data, key):
    # Create a cipher object with IV = 16 * '\\0'
    iv = b'\x00' * 16
    aes_cipher = AES.new(key, AES.MODE_CBC, iv)

    # Decode the data from Base64 and remove padding if necessary
    decoded_data = base64.b64decode(data)
    unpadded_data = unpad(decoded_data, AES.block_size)

    # Decrypt the padded data using CBC mode
    decrypted_data = aes_cipher.decrypt(unpadded_data)

    return decrypted_data

def unpad(s, bs):
    """
    Remove PKCS#7 padding from a string.
    :param s: The input string to remove paddings from.
    :param bs: Block size of the encryption algorithm (AES uses 16).
    :return: A new string with no paddding at its end.
    """
    return s[:-ord(s[len(s)-1:])]

# Example usage
data = b'encrypted_data_here'
key = b'my_secret_key_123'

decrypted_data = decrypt_aes_cbc(data, key)
print(decrypted_data.decode())