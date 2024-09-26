
def decrypt_obfuscated_string(obfuscated_str):
    delimiter = '04'
    offset = 4142
    blocks = obfuscated_str.split(delimiter)
    decrypted_chars = [chr(offset - int(block)) for block in blocks if block]
    return ''.join(decrypted_chars)

# Example usage:
encrypted_password = '
