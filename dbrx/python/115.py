from flask import Flask
from flask_sqlalchemy import SQLAlchemy
from flask_security import Security, SQLAlchemyUserDatastore
from flask_bcrypt import Bcrypt
from flask_login import LoginManager

# ... other imports ...

db = SQLAlchemy()
user_datastore = None  # Initialize here and assign later in the create_app function.
bcrypt = Bcrypt()
login_manager = LoginManager()

def create_app():
    app = Flask(__name__, instance_relative_config=True)
    
    from .models import User, Role
    
    app.config['SECRET_KEY'] = 'secret_key_here'
    app.config['SQLALCHEMY_DATABASE_URI'] = 'sqlite:///your_database.db'

    bcrypt.init_app(app)
    login_manager.init_app(app)

    with app.app_context():
        db.init_app(app)
        # Assign SQLAlchemyUserDatastore to the global variable.
        global user_datastore
        user_datastore = SQLAlchemyUserDatastore(db, User, Role) 
        security = Security(app, user_datastore)

    return app