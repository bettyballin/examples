from flask import Flask
from flask_security import Security, SQLAlchemyUserDatastore
from flask_sqlalchemy import SQLAlchemy
from flask_security.utils import encrypt_password, verify_password

app = Flask(__name__)
app.config['SECRET_KEY'] = 'super-secret'
app.config['SQLALCHEMY_DATABASE_URI'] = 'sqlite:///example.db'

db = SQLAlchemy(app)

class User(db.Model):
    id = db.Column(db.Integer, primary_key=True)
    email = db.Column(db.String(255), unique=True)
    password = db.Column(db.String(255))

    def __init__(self, email, password):
        self.email = email
        self.password = encrypt_password(password)

    def verify(self, password):
        return verify_password(password, self.password)

user_datastore = SQLAlchemyUserDatastore(db, User)
security = Security(app, user_datastore)

@app.before_first_request
def create_user():
    db.create_all()
    user = User('test@example.com', 'password')
    db.session.add(user)
    db.session.commit()

if __name__ == '__main__':
    app.run(debug=True)