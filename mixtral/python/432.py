from functools import wraps
from flask import flash, redirect, url_for
from flask_login import current_user, logout_user

def admin_required(f):
    @wraps(f)
    def decorated(*args, **kwargs):
        if not current_user.is_admin:
            flash('You must have administrator privileges to access this page.', 'error')
            logout_user()
            return redirect(url_for('login'))

        return f(*args, **kwargs)

    return decorated