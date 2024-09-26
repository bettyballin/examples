import base64
import ecdsa

def base64url_to_bytes(s):
    s = s.replace('-', '+').replace('_', '/')
    return base64.b64decode(s + '=' * (4 - len(s) % 4))

x_value = base64url_to_bytes("ARriqkpHlC1Ia1Tk86EM_bqH_9a88Oh2zMYF3fUUGJw")
y_value = base64url_to_bytes("wTYd3CEiwTk1n-lFPdpZ51P4Z0EzlVNXLvJMY-k55pQ")

x, y = int.from_bytes(x_value, byteorder='big'), int.from_bytes(y_value, byteorder='big')

point = ecdsa.ellipticcurve.Point(ecdsa.SECP256k1.curve, x, y)
print(point)