from cryptography.hazmat.primitives import padding

def unpad_pkcs5(data):
    padder = padding.PKCS7(128).unpadder()

    try:
        return padder.update(data) + padder.finalize()

    except ValueError as e:
        print("Error occurred during unpadding:", str(e))

# Example usage
ciphertext = b"453947000000197708080808"
plaintext = unpad_pkcs5(ciphertext)
print("Plaintext:", plaintext.decode())