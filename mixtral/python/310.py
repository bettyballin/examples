import hashlib
import binascii

def validate_password(hashed_password, plain_password):
    salt = hashed_password.split('$')[2]
    stored_hash = hashed_password.split('$')[3]
    new_hash = hashlib.pbkdf2_hmac('sha512', plain_password.encode('utf-8'), salt.encode('utf-8'), 25000)
    new_hash = binascii.hexlify(new_hash).decode('utf-8')
    return new_hash == stored_hash

hashed_password = "$pbkdf2-sha512$25000$pXROaU2JUSrlnDPm3BsjBA$ckspsls2SWPhl9dY7XDiAZh5yucWq27fWRuVj4aOUc5dA2Ez5VH1LYiz5KjaZJscaJYAFhWIwPhkAsHiPOrvrg"
plain_password = "123456"

print(validate_password(hashed_password, plain_password))