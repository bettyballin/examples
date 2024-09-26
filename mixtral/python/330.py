import jwt

token = "your_jwt_token_here"
public_key = "your_public_key_here"

decoded = jwt.decode(token, public_key, algorithms=["ES384"])
print("Decoded:", decoded)