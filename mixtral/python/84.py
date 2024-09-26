import base64

def convert_to_specialcharacters(hashed):
    return base64.b32encode(base64.urlsafe_b64decode(hashed)).rstrip().replace('=','')

hashed = "yourHashedValue"

password = convert_to_specialcharacters(hashed)

print("Password:", password)