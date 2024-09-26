from flask import current_app
from flask_security import user_logged_out

def delete_auth_token(sender, **kwargs):
    current_app.logger.info('User logged out. Deleting auth token.')
    # Replace this with your actual auth token deletion logic
    # For example:
    # auth_token = kwargs['user'].auth_token
    # Your database or cache logic to delete the token goes here
    pass

user_logged_out.connect(delete_auth_token)