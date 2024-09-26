import jwt

encoded = "your_encoded_jwt_token_here"
print(jwt.get_unverified_header(encoded))