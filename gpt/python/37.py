
import gnupg

def decrypt_file(file_in, file_out, key_passwd):
    gpg = gnupg.GPG()
    
    # Read the encrypted file
    with open(file_in, "rb") as f:
        encrypted_data = f.read()
    
    # Decrypt the data
    decrypted_data = gpg.decrypt(encrypted_data, passphrase=key_passwd)
    
    # Check decryption was successful
    if not decrypted_data.ok:
        raise ValueError("Decryption failed.")
    
    # Write the decrypted data to the output file
    with open
