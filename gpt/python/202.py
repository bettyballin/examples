
from app import create_app
from app.models import db
from app.models.user import Role, User
from flask_security import SQLAlchemyUserDatastore
from flask_security.utils import encrypt_password
import datetime

# Create an instance of the Flask application
app = create_app()

# Push the application context
with app.app_context():
    # Initialize the database
    db.create_all()

    # Create a SQLAlchemyUserDatastore instance for creating users and roles
    user_datastore = SQLAlchemyUserDatastore(db, User, Role)

    # Create roles
    user_role = Role(name='user')
    super_user_role = Role(name='superuser')
    db.session.add(user_role)
    db.session.add(super_user_role)
    db.session.commit()

    # Create an admin user
    admin_user = user_datastore.create_user(
        username='admin',
        email='admin@example
