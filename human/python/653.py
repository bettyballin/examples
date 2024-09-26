from pyasn1.codec.der import decoder 
from pyasn1_modules import rfc5208
from pyasn1_modules import rfc5915

def decode_keys(content):
    asn1Object, _ = decoder.decode(content, asn1Spec=rfc5208.PrivateKeyInfo())
    rawKeys = asn1Object.getComponentByName('privateKey').asOctets()
    asn1Object, _ = decoder.decode(rawKeys, asn1Spec=rfc5915.ECPrivateKey())
    privateKey = asn1Object.getComponentByName('privateKey').asOctets()
    uncompressedPublicKey = asn1Object.getComponentByName('publicKey').asOctets()
    return privateKey, uncompressedPublicKey

# Example usage:
content = b'...'  # replace with your DER-encoded PrivateKeyInfo content
privateKey, uncompressedPublicKey = decode_keys(content)
print(privateKey)
print(uncompressedPublicKey)