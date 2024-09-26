import boto3
import base64

kms = boto3.client('kms')

# Assuming encryptionDetails is a dictionary containing the encrypted key
encryptionDetails = {'key': 'your_base64_encoded_encrypted_key'}

# Decrypting encrypted AES Key
decrypted_key = kms.decrypt(CiphertextBlob=base64.b64decode(encryptionDetails['key']))

# Extract the decoded key
aes_key = base64.urlsafe_b64encode(decrypted_key["Plaintext"])