
from datetime import datetime
from flask_security import MongoEngineUserDatastore, UserMixin, RoleMixin
from your_application import app, db  # Assuming you have initialized these

# Define your User and Role models if you haven't already
class Role(db.Document, RoleMixin):
    name = db.StringField(max_length=80, unique=True)
    description = db.StringField(max_length=255)

class User(db.Document, UserMixin):
    email = db.StringField(max_length=255)
    password = db.StringField(max_length=255)
    active = db.BooleanField(default=True)
    fs_uniquifier = db.StringField(max_length=64, unique=True, nullable=False)
    confirmed_at = db.DateTimeField()
    roles = db.ListField(db.ReferenceField(Role), default=[])

# Setup Flask-Security
user_datastore = MongoEngineUserDatastore(db, User, Role)

# Now, when you create a user, set
