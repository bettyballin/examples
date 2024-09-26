import hashlib
from binascii import a2b_hex

def Encrypt_Pass(password, authenticator, secret):
    m = hashlib.md5()
    m.update(secret + a2b_hex(authenticator))
    return "".join(chr(ord(x) ^ ord(y)) for x, y in zip(password.ljust(16,'\0')[:16], m.digest()[:16]))

result = Encrypt_Pass("cisco123","344c71c77a2b845b8856ffa968740b73","sharedsecret")
ciphertext = "6ed3a35440abe69b2e8698109b809932"#plaintext is cisco123
print(result.encode("hex"))