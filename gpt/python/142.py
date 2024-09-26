
from itsdangerous import Serializer
from time import time

def generate_auth_token(user_id, secret_key, expiration=3600):
    s = Serializer(secret_key, expires_in=expiration)
    token = s.dumps({
        'id': user_id,
        'timestamp': time()  # Add the current timestamp
    })
    return token

# Usage
app.config['SECRET_KEY'] = 'your_secret_key'
token = generate_auth_token(user.id, app.config['SECRET_KEY'])

