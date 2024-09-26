import jwt

encoded = jwt.encode({'some': 'payload'}, 'secret', algorithm='HS256')
decoded = jwt.decode(encoded, options={"verify_signature": False})

print(decoded)