from Crypto.PublicKey import RSA

with open('client_publickey.pub', 'r') as f:
    pub_key = RSA.importKey(f.read())

message = "Your secret text"
encrypted_msg = pub_key.encrypt(message.encode(), 32)[0]