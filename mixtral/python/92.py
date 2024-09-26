import hmac
import hashlib
import base64

e_mail = 'me@mydomain.com'
password = 'Secret'

challenge = '15993b900f954e659a016cf073ef90c1'.encode()

sha_sum = hashlib.new('sha1')
sha_sum.update(e_mail.encode())
sha_hexdigest = sha_sum.hexdigest()[0:8]
e = '$p5k2$2710${}'.format(sha_hexdigest).encode()

res = hashlib.pbkdf2_hmac('sha256', password.encode(), e, 10000)
r = base64.b64encode(res).decode().replace("+", "")

hashstr = '{}:{}'.format(e.decode(), r)

hmac_obj = hmac.new(hashstr.encode('utf-8'), challenge, hashlib.sha1)
saltedHash = hmac_obj.hexdigest()

print(saltedHash)