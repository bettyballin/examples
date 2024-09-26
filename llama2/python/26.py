from flask import Flask, current_app
from flask_security import login_user, logout_user
from flask_security.utils import generate_password_hash
from flask_security.mongoengine import MongoEngineUserDatastore
from mongoengine import connect

app = Flask(__name__)
app.config['SECRET_KEY'] = 'secret_key_here'
app.config['SECURITY_PASSWORD_SALT'] = 'password_salt_here'

connect('your_database_name', host='your_database_host')

user_datastore = MongoEngineUserDatastore(current_app._get_current_object())

@app.before_first_request
def create_user():
    new_user = user_datastore.create_user(
        email='johndoe@example.com',
        password=generate_password_hash('password123'),
        confirmed=True
    )
    login_user(new_user)

if __name__ == '__main__':
    app.run(debug=True)