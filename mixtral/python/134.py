from binascii import unhexlify
import hashlib

master_key = "02F840A04114081690223B7069071A70D6DABB891763B638CC20C7EC3BD58E6C86"
master_key = unhexlify(master_key)
print(hashlib.sha256(master_key).hexdigest())