
import rsa

# Generate new RSA keys
(public_key, private_key) = rsa.newkeys(2048)

# Save the private key to a file
private_key_pem = private_key.save_pkcs1().decode('utf-8')
with open('private.pem', 'w') as privatefile:
    privatefile.write(private_key_pem)

# Save the public key to a file
public_key_pem = public_key.save_pkcs1().decode('utf-8')
with open('public.pem', 'w') as publicfile:
    publicfile.write(public_key_pem)

