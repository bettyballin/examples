from modules.auth.models import User
from flask import Blueprint, request, abort
from flask_restful import Api, Resource
from flask_security import login_required
from flask_security.utils import verify_password, login_user, logout_user 

app = Blueprint(__name__, __name__)
api = Api(app)

class LogResource(Resource):
    """
    Manages user login and logout
    """

    def post(self):
        data = request.get_json()
        if not data:
            abort(400, 'Missing JSON data')

        email = data.get('email')
        password = data.get('password')

        if not email or not password:
            abort(400, 'Email and password are required')

        user = User.query.filter_by(email=email).first()
        if not user or not verify_password(password, user.password):
            abort(401, 'Invalid email or password')

        login_user(user)
        return {'message': 'Logged in successfully'}, 200

    @login_required
    def delete(self):
        logout_user()
        return {'message': 'Logged out successfully'}, 200

api.add_resource(LogResource, '/log', endpoint='log')