from OpenSSL import crypto

p12 = crypto.PKCS12()
p12.set_privatekey(crypto.PKey())
p12.set_certificate(crypto.X509())
p12.set_ca_certificates([])
p12.set_friendlyname(b'friendly name')
p12.set_privatekey_pem_passphrase(b'mysecretpassword')
p12.export(b'mysecretpassword', crypto.FILETYPE_PEM, b'mysecretpassword', crypto.AES_128_CBC)