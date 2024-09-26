from functools import wraps
from flask import app

def token_decorator(func):
    @wraps(func)
    def wrapper(*args, **kwargs):
        with app.app_context():
            return auth_token_required("token")(func)(*args, **kwargs)

    return wrapper