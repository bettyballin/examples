import hmac
import hashlib
import base64

e_mail = 'me@mydomain.com'
password = 'Secret'

challenge = b'15993b900f954e659a016cf073ef90c1'

shasum = hashlib.new('sha1')
shasum.update(e_mail.encode())
shasum_hexdigest = shasum.hexdigest()
shasum_substring = shasum_hexdigest[0:8]
e = '$p5k2$2710$' + shasum_substring

res = hashlib.pbkdf2_hmac('sha256', password.encode(), e.encode(), 10000, dklen=32)
r = base64.b64encode(res).decode().replace('+', '.')

hashstr = str(e) + '$' + r
hmac1 = hmac.new(challenge, hashstr.encode(), 'sha1')
saltedHash = hmac1.hexdigest()

print(saltedHash)