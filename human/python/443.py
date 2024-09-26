import ecdsa

# Private key
private_key = bytes.fromhex("63bd3b01c5ce749d87f5f7481232a93540acdb0f7b5c014ecd9cd32b041d6f33")

# Public point (Uncompressed)
public_point = bytes.fromhex("04017655e42a892cc71bccedcb1cd421d03530e1d7edb52cef143c5562c4c6f0129fa5a37738013e64a1ff0e6cb7068815a13000eb162cb7a0214dfcf3c8fa101c")

# Signature
signature = bytes.fromhex("304402200308ac7b7a56e7227d665d8f652d849935b4876c5ecef252ed9713c975b0a6280220696c134bb6e115b9ac18790c27009938f081bfaf063e547ce75bad3c9682890b")

# Create a SigningKey object from the private key
sk = ecdsa.SigningKey.from_string(private_key, curve=ecdsa.SECP256k1)

# Create a VerifyingKey object from the public point
vk = ecdsa.VerifyingKey.from_string(public_point[1:], curve=ecdsa.SECP256k1)

# Verify the signature
try:
    vk.verify(signature[2:], b"message")
    print("Verification OK")
except ecdsa.BadSignatureError:
    print("Verification failed")