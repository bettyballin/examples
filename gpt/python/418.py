
def load_public_key_from_spki(spki_b64: str):
    # Decode the base64 string to get the binary representation of the key
    spki_der = base64.b64decode(spki_b64)
    
    # Load the binary key into a public key object
    public_key = serialization.load_der_public_key(spki_der)
    
    return public_key

