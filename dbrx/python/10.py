from flask import Flask
from flask_security import Security, MongoEngineUserDatastore
from flask_mongoengine import MongoEngine
from flask_security.utils import encrypt_password
from datetime import datetime

app = Flask(__name__)
app.config['MONGODB_DB'] = 'your_database_name'
app.config['MONGODB_HOST'] = 'mongodb://localhost/your_database_name'
app.config['SECRET_KEY'] = 'your_secret_key'

db = MongoEngine(app)

user_datastore = MongoEngineUserDatastore(db, 'User', 'Role')

app.security = Security(app, user_datastore)

user = user_datastore.create_user(
    username='username',
    password=encrypt_password('password')
)

# Set 'confirmed_at' to current datetime or any other valid value:
user.confirmed_at = datetime.utcnow()