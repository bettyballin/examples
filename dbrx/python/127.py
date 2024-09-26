from flask import Flask
from flask_security import Security, SQLAlchemyUserDatastore
from flask_security.views import ResetPasswordView
from flask_sqlalchemy import SQLAlchemy

app = Flask(__name__)
app.config['SECRET_KEY'] = 'super-secret'
app.config['SECURITY_PASSWORD_SALT'] = 'password-salt'
app.config['SQLALCHEMY_DATABASE_URI'] = 'sqlite:///example.db'

db = SQLAlchemy(app)

class User(db.Model):
    id = db.Column(db.Integer, primary_key=True)
    email = db.Column(db.String(255), unique=True)
    password = db.Column(db.String(255))
    active = db.Column(db.Boolean())
    confirmed_at = db.Column(db.DateTime())

class Role(db.Model):
    id = db.Column(db.Integer, primary_key=True)
    name = db.Column(db.String(40))
    description = db.Column(db.String(255))

user_datastore = SQLAlchemyUserDatastore(db, User, Role)
security = Security(app, user_datastore)

class MyResetPasswordView(ResetPasswordView):
    def dispatch_request(self, token, *args, **kwargs):
        # Call super().dispatch_request() to handle password reset logic
        response = super(MyResetPasswordView, self).dispatch_request(token, *args, **kwargs)

        # Log out the user after resetting their password
        from flask_security.utils import logout_user
        logout_user()

        return response

# Register your custom view with Flask-Security
security.reset_password_view = MyResetPasswordView.as_view('reset_password')

if __name__ == '__main__':
    app.run(debug=True)