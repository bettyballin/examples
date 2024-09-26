from OpenSSL import crypto
import getpass

# open it, using password. Supply/read your own from stdin.
passwd = getpass.getpass("Enter password: ")
p12 = crypto.load_pkcs12(open("/path/to/cert.p12", 'rb').read(), passwd.encode())

# get various properties of said file.
# note these are PyOpenSSL objects, not strings although you
# can convert them to PEM-encoded strings.
cert = p12.get_certificate()     # (signed) certificate object
key = p12.get_privatekey()      # private key.
ca_certs = p12.get_ca_certificates() # ca chain.

# Example usage:
print(crypto.dump_certificate(crypto.FILETYPE_PEM, cert).decode())
print(crypto.dump_privatekey(crypto.FILETYPE_PEM, key).decode())
for ca_cert in ca_certs:
    print(crypto.dump_certificate(crypto.FILETYPE_PEM, ca_cert).decode())