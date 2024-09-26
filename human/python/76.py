from flask import Flask, jsonify
from flask_security import current_user, auth_token_required, Security, SQLAlchemyUserDatastore
from flask_sqlalchemy import SQLAlchemy

app = Flask(__name__)
app.config['SECRET_KEY'] = 'super-secret'
app.config['SECURITY_TOKEN_SALT'] = 'salt'
app.config['SQLALCHEMY_DATABASE_URI'] = 'sqlite:///example.db'

db = SQLAlchemy(app)

class User(db.Model):
    id = db.Column(db.Integer, primary_key=True)
    email = db.Column(db.String(255), unique=True)
    password = db.Column(db.String(255))

user_datastore = SQLAlchemyUserDatastore(db, User, None)
security = Security(app, user_datastore)

@app.route('/')
@auth_token_required
def view():
    return jsonify({'user_id': current_user.id})

if __name__ == '__main__':
    app.run(debug=True)