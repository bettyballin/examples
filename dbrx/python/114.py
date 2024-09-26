from flask_security import SQLAlchemyUserDatastore
from yourapp import db
from yourapp.models import Role, User

user_datastore = SQLAlchemyUserDatastore(db, User, Role)