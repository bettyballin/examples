from itsdangerous import TimedJSONWebSignatureSerializer as Serializer

def create_token(secret_key, expires_in, data):
    s = Serializer(secret_key, expires_in=expires_in)
    return s.dumps(data)

def load_token(secret_key, token):
    s = Serializer(secret_key)
    try:
        return s.loads(token)
    except Exception as e:
        return str(e)

# Test the functions
secret_key = 'sekrit'
data = {'id': 'foobar'}

token = create_token(secret_key, 3600, data)
print(token)
print(load_token(secret_key, token))

token = create_token(secret_key, 0, data)
print(token)
print(load_token(secret_key, token))