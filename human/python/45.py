from Crypto.PublicKey import RSA
from Crypto.Util import asn1
from base64 import b64decode

key64 = 'MIGJAoGBAJNrHWRFgWLqgzSmLBq2G89exgi/Jk1NWhbFB9gHc9MLORmP3BOCJS9k\
onzT/+Dk1hdZf00JGgZeuJGoXK9PX3CIKQKRQRHpi5e1vmOCrmHN5VMOxGO4d+znJDEbNHOD\
ZR4HzsSdpQ9SGMSx7raJJedEIbr0IP6DgnWgiA7R1mUdAgMBAAE='

keyDER = b64decode(key64)
seq = asn1.DerSequence()
seq.decode(keyDER)
keyPub = RSA.construct( (seq[0], seq[1]) )

# Example usage:
print(keyPub.publickey().exportKey('PEM'))