decrypted_message = encryption_type.decrypt(original).decode("utf-8")

# Split the string by comma and space
parts = decrypted_message[1:-1].split(", ")

ip, username, password = None, None, None
for part in parts:
    key, value = part.strip().split('=')

    if 'ip' == key.strip():
        ip = value.replace("\\\"", "")

    elif 'username' == key.strip():
        username = value.replace("\\\"", "")

    elif 'password' == key.strip():
        password = value.replace("\\\"", "")

print(f"IP: {ip}\nUsername: {username}\nPassword: {password}")