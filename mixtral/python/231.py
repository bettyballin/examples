from flask import current_app, request
from flask_login import login_user
from flask_security import verify_password
from flask_restful import Resource

class LogResource(Resource):
    """Manages user login and logout"""

    def post(self):
        if verify_password(request.form['password'], user.password):
            login_user(user)
            current_app.security.datastore.commit()
            return "Logged in"