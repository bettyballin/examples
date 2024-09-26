import re

decrypted_message = encryption_type.decrypt(original).decode("utf-8")

# Use regular expressions to extract the values
matches = re.findall(r'(\w+)="([^"]*)"', decrypted_message)

ip, username, password = None, None, None
for key, value in matches:
    if key == 'ip':
        ip = value
    elif key == 'username':
        username = value
    elif key == 'password':
        password = value

print(f"IP: {ip}\nUsername: {username}\nPassword: {password}")