from Crypto.Cipher import AES

BLOCK_SIZE = 32
PADDING = b'0'

def pad(s):
    return s + (BLOCK_SIZE - len(s) % BLOCK_SIZE) * PADDING

def EncodeAES(c, s):
    return c.encrypt(pad(s))

def DecodeAES(c, e):
    return c.decrypt(e).rstrip(PADDING)

secret = 'à¤à¤à¤à¤à¤..'.encode('utf-8')
message = 'à¤à¤à¤à¤à¤à¤à¤à¤à¤à¤à¤'.encode('utf-8')

obj = AES.new(secret)

encoded = EncodeAES(obj, message)
decoded = DecodeAES(obj, encoded)

print('Decrypted string:', decoded.decode('utf-8'))