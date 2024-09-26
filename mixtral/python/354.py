import json
import base64

def card_encrypt(iv, key, decodedData):
    # your encryption function implementation here
    pass

data = {'key': 'value'}  # replace with your data
data = json.dumps(data, separators=(',', ':')).encode()
encoded_data = base64.b64encode(data).decode('utf-8')

# Decode the `base64` encoded data before passing it into your encryption function
decodedData = base64.b64decode(encoded_data)

iv = b''  # replace with your initialization vector
key = b''  # replace with your encryption key

encryptedCardDetails = card_encrypt(iv, key, decodedData)