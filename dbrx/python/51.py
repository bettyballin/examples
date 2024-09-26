from flask import current_app
from flask_security import user_logged_in

def save_auth_token(sender, **kwargs):
    # Save auth token when a user logs in
    auth_token = kwargs.get('request').headers.get('Authorization')
    user_id = kwargs.get('user').id

    # Assuming you have a User model with an 'auth_token' field
    from yourapp.models import User
    user = User.query.get(user_id)
    user.auth_token = auth_token
    current_app.db.session.commit()

user_logged_in.connect(save_auth_token)