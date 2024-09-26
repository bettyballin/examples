
import hmac
import hashlib
import base64

def osa_hash(email, password):
    shasum = hashlib.sha1(email.encode()).hexdigest()
    e = '$p5k2$2710$' + shasum[:8]
    res = hashlib.pbkdf2_hmac('sha256', password.encode(), e.encode(), 10000, 32)
    r = base64.b64encode(res).decode().replace('+', '.')
    return e + '$' + r

def create_hash(email, password, challenge):
    hash_val = osa_hash(email, password)
    hmac_val = hmac.new(hash_val.encode(), challenge.encode(), hashlib.sha1)
    salted_hash = hmac_val.hexdigest()
    return salted_hash

e_mail = 'me@mydomain.com'
password = 'Secret'
challenge = '15993b900f954e659a016cf073ef90c1'

salted_hash = create_hash(e_mail, password, challenge)
print(salted_hash)

