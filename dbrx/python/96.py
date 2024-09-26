from OpenSSL.crypto import load_privatekey, FILETYPE_PEM

key_file = "path_to_your_private_key.pem"  # replace with your private key file path

private_key = load_privatekey(
    FILETYPE_PEM, 
    open(key_file).read()
)