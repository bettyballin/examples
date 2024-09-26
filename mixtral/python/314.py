from cryptography.fernet import Fernet, InvalidToken

# assuming 'data' and 'cipher_suite' are defined elsewhere
data = data.strip().encode('utf-8')
try:
    token = cipher_suite.decrypt(data)
except InvalidToken as e:
    print("wow")