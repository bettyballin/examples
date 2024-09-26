
from flask_security import Security, SQLAlchemyUserDatastore, UserMixin, RoleMixin, login_required
from flask_security.signals import user_logged_in, user_logged_out
from flask_sqlalchemy import SQLAlchemy
from flask import Flask, render_template_string, current_app
from your_application import db, User  # assuming you have your User model and db defined

# Initialize Flask and Flask-Security as usual
app = Flask(__name__)
app.config['SECRET_KEY'] = 'super-secret'
app.config['SQLALCHEMY_DATABASE_URI'] = 'sqlite://'
app.config['SECURITY_TOKEN_AUTHENTICATION_HEADER'] = 'Authentication-Token'
db.init_app(app)
security = Security(app, user_datastore)

# Define a handler for the login signal
@user_logged_in.connect_via(app)
def on_user_logged_in(sender
