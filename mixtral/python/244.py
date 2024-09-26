import hashlib

def blockhash(sender_bytes, msg_bytes, signature_bytes, nonce, timestamp):
    h = hashlib.sha256()

    # Convert integer to bytes
    nonce_bytes = int(nonce).to_bytes((int(nonce).bit_length() + 7) // 8, "big")

    # Fixed-point representation of timestamp
    fixed_timestamp = str(timestamp * (10 ** 6)).encode('utf-8')

    hash_str = sender_bytes + msg_bytes + signature_bytes + nonce_bytes + fixed_timestamp

    h.update(hash_str)

    finalhash = h.hexdigest()

    return finalhash