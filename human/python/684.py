import base64
import hashlib
from Crypto.Cipher import AES
from Crypto.PublicKey import RSA
from Crypto.Util.Padding import unpad

def decrypt_enc_key(enc_key, iv, salt, password):
    password_salt = password + salt
    h = hashlib.md5()
    h.update(password_salt)
    aes_key = h.digest()
    cipher = AES.new(aes_key, AES.MODE_CBC, iv)
    dec_key = unpad(cipher.decrypt(enc_key), AES.block_size)
    return dec_key

def import_rsa_key(dec_key):
    return RSA.import_key(dec_key)

def export_rsa_key(rsa_key):
    return rsa_key.exportKey(format='PEM', passphrase=None, pkcs=1, protection=None).decode('utf-8')

def main():
    enc_key = base64.b64decode('crTik10vEjqh9a2lsKQLwKxFANAcSrivDZ8uiRQlC/DHJJnRsDwZz6Q0Cqsiv/xutt00P3TwSH7qEbQeyaTUEPmXcu3GNVpwKryxXCRm9H6Ggx8pbXZk/T5MN2WOHZuB7t8u6O9F93ZuIVIgUHkhI6G7GUHdvzbeJttgsMn24sJegvXfsKT1VOZzotLEhckFgnPtFZxH6YvgGZqBX+NLvQ/MRiaosTmbp3IvT+KECVP159ypCK754csDazAB09qqbTYV0KBlN360F8b3E4Ty/pGB3GY30DXAlbrHdA4i/VJegDVUYxYkqQZfsNi3rBmuwJfjEjGB4tDZ4DoEc55WvRa4vWyPFjwcEDZPXMYqPyo49PNlzTXK+qDiJpqwpYza8t8k6xogzPSsyF+SKTplpyHyiAhUBZTLg1MXUxKtwSKxd85hinAUBihQZkMiD9qks1oEyuxavCz8VuTZypF99lPNP1kvSkKKTlTumSGhrSQ+ZNPs1GKCjmpWv+qXXhStmbOV0DJCUyLGaNz/83iGg+aQSQLil+uSP6KOOczcqwUtzwyFO0ecJk7Fvyr1JTGzi3rPjcuBpFR8w+Z5sf5ZD0gvfwjBpq5QqOw4jXUJpUpxKs5FP1EmOh2a813pZGBue3r+NxLFmgAjU8wnioomjEV1QJRiZ42bE0QO9OW8Mt5at/Bcu8cDHbJ2NT3i9jL/jrPLKFB80fJOLB/TppuiWtycaju1IXgrXbLH2oPKHJ3CzzDyVmRDrpPKhgh1INO1gJYHFfTsj/JBII59RQKrEIIQs+upjrjoJWkS2YyGva91PxvJPA1ntHTxVua58gZH/QN1ZCen8Ib4H558XPlNy+U6djYoV9uvyFN15Helqyet5lpDha/uXTbSK4vSgZttyvDkYM2rIFQmK7HdgQbtd+Zupn6M5XfASfECdU5DblQYUqdSfVFu3VZnbH52jmXPimNFrATY10rm5KF3aaz5UBqACfJnSpr3UYBiLEX7lbrXDGQbqK1R6FyJj4cu5nUptKunQCXWmW/YcWjhSNbHyWW/k2QpV/58KMN75mpl9dMGhWk33HcgMtWQ20cy9IzG+FdivYkP7uexEqyUaMXUkvi43yH5MR/s+X0HJ5SAojW0wiB9ev3aBFhxs9XtTiG9dAEl/UC154UwH6HUWlL0a3SuOnIWnR89A6m1ov/CI8I2oqyqKSeeKF0raJJs2e5O1Cvuko9q+g+eVovDCGZeraVGdJn9+4922tKw/OvQdy+unpMpGxUyx4U/bKYBC3PytAaFHA1j7bjNvl8Xs5dPWzflo9OEU1Dx4Naat/yPoxvm0UJyoEoJA1eqYEG2bdbpUqJJMfF1n0BZirJochELYhF3kG3JaJzn6ER7MNW/yzJuNQGx7bli3CHAs1QhgDMM1LLtmpAAm9WdqEo57DjX+UBFOHo/Q5R7dR5h1bbxeQJxFwbBTSauVFfVUySt3Af7r7C2bQZnkvTU2mxoxg3DXCy0dsN28A/V558ZERmiVT1OkmUxXh/hKHAes8kNB27VbhoWaV5igMcrYuImw3wGKXZ4DszmaIMYNLMvo4N3PbkbuwklTX8eQh1AeQRMCSbb')
    iv = bytes.fromhex('269A1092E26672B45D40F2286B378739')
    salt = iv[:8]
    password = b'qwerty0123456789'
    
    dec_key = decrypt_enc_key(enc_key, iv, salt, password)
    rsa_key = import_rsa_key(dec_key)
    print(export_rsa_key(rsa_key))

if __name__ == "__main__":
    main()