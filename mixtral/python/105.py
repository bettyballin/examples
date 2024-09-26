from cryptography.fernet import Fernet

key = Fernet.generate_key()
cipher_suite = Fernet(key)

string = input('String here: ')
byte_data = bytes(string, 'utf-8')
cipher_text = cipher_suite.encrypt(byte_data)

print(cipher_text)