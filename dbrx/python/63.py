import secrets

def access_granted():
    print("Access granted!")

secret = 25134231
if int(secrets.token_hex(8), 16) == secret:
    access_granted()