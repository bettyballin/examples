
from OpenSSL import crypto

key = crypto.PKey()
key.generate_key(crypto.TYPE_RSA, 2048)

cert = crypto.X509()
cert.set_serial_number(1)
cert.get_subject().CN = "me"
cert.set_issuer(cert.get_subject())
cert.gmtime_adj_notBefore(0)
cert.gmtime_adj_notAfter(10 * 365 * 24 * 60 * 60)
cert.set_pubkey(key)
cert.sign(key, 'sha256')

with open("certificate.cer", 'wb') as f:
    f.write
