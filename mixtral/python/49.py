import jwt
from datetime import datetime, timedelta

SECRET_KEY = "your_secret_key_here"

def create_token(user):
    expiration_time = timedelta(minutes=30)

    payload = {
        "sub": user.id,
        "iat": datetime.utcnow(),
        "exp": datetime.utcnow() + expiration_time
    }

    token = jwt.encode(payload, SECRET_KEY, algorithm="HS256")

    return token

def decode_token(token):

    try:

        decoded_token = jwt.decode(token, SECRET_KEY)

        user_id = decoded_token["sub"]

        # Fetch the User from your database

        return get_user_by_id(user_id), True

    except:

        return None, False

def get_user_by_id(user_id):
    # Implement your database logic here
    pass