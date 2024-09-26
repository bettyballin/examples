import re

testing = 'ip = "192.168.1.1" username = "admin" password = "password123"'

ip_pattern = r"ip\s*=\s*\"?(\S+)\"?"
username_pattern = r"username\s*=\s*\"?(\w+)\"?"
password_pattern = r"password\s*=\s*\"?(\w+)\"?"

matches = re.findall(ip_pattern, testing)
ip = matches[0]

matches = re.findall(username_pattern, testing)
username = matches[0]

matches = re.findall(password_pattern, testing)
password = matches[0]

print("IP:", ip)
print("Username:", username)
print("Password:", password)