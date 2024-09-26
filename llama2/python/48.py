from flask import Flask, request, jsonify
from flask_security import Security, SQLAlchemyUserDatastore, UserMixin, RoleMixin, login_user, create_token

app = Flask(__name__)
app.config['SECRET_KEY'] = 'super-secret'
app.config['SECURITY_TOKEN_SALT'] = 'super-salt'

from sqlalchemy import create_engine
from sqlalchemy.orm import sessionmaker
from sqlalchemy.ext.declarative import declarative_base

engine = create_engine('sqlite:///example.db')
Session = sessionmaker(bind=engine)
Base = declarative_base()

class User(Base, UserMixin):
    __tablename__ = 'users'
    id = db.Column(db.Integer, primary_key=True)
    username = db.Column(db.String(255), unique=True)
    password = db.Column(db.String(255))

    def __init__(self, username):
        self.username = username

    def authenticate(self, password):
        return self.password == password

class Role(Base, RoleMixin):
    __tablename__ = 'roles'
    id = db.Column(db.Integer, primary_key=True)
    name = db.Column(db.String(255), unique=True)

Base.metadata.create_all(engine)

security = Security(app, SQLAlchemyUserDatastore(session=Session, user_model=User, role_model=Role))

@app.route('/login', methods=['POST'])
def login():
    data = request.get_json()
    username = data['username']
    password = data['password']
    user = User.query.filter_by(username=username).first()
    if not user or not user.authenticate(password):
        return jsonify({'error': 'Invalid credentials'}, 401)
    token = create_token(user)
    return jsonify({'token': token}, 200)

if __name__ == '__main__':
    app.run(debug=True)