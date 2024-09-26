
from flask import abort, flash, redirect, url_for
from flask_login import current_user
from functools import wraps

def roles_required_for_endpoint(roles):
    def wrapper(fn):
        @wraps(fn)
        def decorated_view(*args
