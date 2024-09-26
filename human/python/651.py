from pyasn1.codec.der import decoder 
import codecs

content = b'''-----BEGIN PRIVATE KEY-----
MIGHAgEAMBMGByqGSM49AgEGCCqGSM49AwEHBG0wawIBAQQgSV6yVAIJil6nb3fN
zbRkMpIzDGjxooZRfZVYaoiDnLmhRANCAASgQDzFeJoU1etfMcPu5PeDXqnV4K4d
7lTj+RQaR/eE2DwCzZMq0y/Fvl8/S5JvWnscCjSwVu50nY2G3yrR/YgI
-----END PRIVATE KEY-----'''

# convert pem to der
content = content.replace(b"-----BEGIN PRIVATE KEY-----", b"")
content = content.replace(b"-----END PRIVATE KEY-----", b"")
content = codecs.decode(content, 'base64')

# decode der with asn1 library
# - get the octet string (field-2) containing the raw key
asn1Object, _ = decoder.decode(content)
rawKeys = asn1Object.getComponentByName('field-2').asOctets()
# - get the octet string (field-1) containing the raw private key 
#   and the bit string (field-2) containing the uncompressed public key
asn1Object, _ = decoder.decode(rawKeys)
privateKey = asn1Object.getComponentByName('field-1').asOctets()
print(f'Private key (hex):             {privateKey.hex()}')
print(f'Private key (int):             {int.from_bytes(privateKey, byteorder="big")}')
uncompressedPublicKey = asn1Object.getComponentByName('field-2').asOctets()
print(f'Uncompressed public key (hex): {uncompressedPublicKey.hex()}')