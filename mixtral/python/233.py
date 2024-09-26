from cryptography.fernet import Fernet, MultiFernet

key_list = []
message = b"foo bar"

for _ in range(4):
    key = Fernet.generate_key()
    fernet_instance = Fernet(key)
    key_list.append(fernet_instance)

multiFernet = MultiFernet(key_list)

token = multiFernet.encrypt(message)
print(token)