
# Assuming the decrypted_message is in the format
# "ip = "192.168.xxx.xxx", username = "xxx", password = "xxx""
decrypted_message = encryption_type.decrypt(original)
testing = decrypted_message.decode("utf-8")

# Remove unwanted characters and split by comma
info_parts = testing.replace('"', '').split(',')

# Create a dictionary to hold the information
info_dict = {}

# Split each part by "=" and strip spaces to get the key-value pairs
for part in info_parts:
    key, value = part.strip().split(' = ')
    info_dict[key] = value

ip = info_dict['ip']
username = info_dict['username']
password = info_dict['password']

print(f"IP: {ip}, Username
