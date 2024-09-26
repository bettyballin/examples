import hashlib
from Crypto.PublicKey import RSA

# Generate keys
private_key = RSA.generate(2048)
public_key = private_key.publickey()

# Load keys
loadedPrivate = private_key
loadedPublic = public_key

# Hash message
messageHashed = hashlib.md5('MyMessage'.encode()).digest()
print('Message MD5:%s' % messageHashed)

# Blind message
blindSigned = loadedPublic.blind(messageHashed, 123)
print('Blinded: %s' % blindSigned)

# Sign blinded message
blindSigned = loadedPrivate.sign(blindSigned, loadedPrivate.n)[0]
print('Blinded Signed: %s' % str(blindSigned))

# Unblind signed message
unblind = loadedPublic.unblind(blindSigned, 123)
print('-------------')
print('Unblinded: %s' % unblind)

# Verify unblinded signature
verify = loadedPublic.verify(unblind, (loadedPrivate.n, loadedPrivate.d))
print('Verify: %s' % verify)