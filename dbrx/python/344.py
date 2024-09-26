import jwt

token = "your_token_here"
decoded_header = jwt.get_unverified_header(token)
print(decoded_header['alg'])  # Should print: RS512