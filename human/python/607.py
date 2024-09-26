import hashlib
import hmac
import base64
import time

def main():
    urlpath = "/0/private/Balance"
    nonce = str(int(time.time() * 1000))

    data = {"nonce": nonce}
    postdata = "&".join(f"{k}={v}" for k, v in data.items())
    encoded = f"{nonce}{postdata}"
    message = urlpath.encode() + hashlib.sha256(encoded.encode()).digest()

    secret_key = "secret".encode()
    signed_key = hmac.new(secret_key, message, hashlib.sha512)
    signature = signed_key.digest()
    b64_encoded_sig = base64.b64encode(signature).decode()
    print("Output:", b64_encoded_sig)

if __name__ == "__main__":
    main()