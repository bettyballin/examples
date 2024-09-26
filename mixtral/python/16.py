from flask import Flask, request
from flask_sqlalchemy import SQLAlchemy

app = Flask(__name__)
app.config['SQLALCHEMY_DATABASE_URI'] = 'sqlite:///users.db'
db = SQLAlchemy(app)

class User(db.Model):
    id = db.Column(db.Integer, primary_key=True)
    username = db.Column(db.String(80), unique=True, nullable=False)

def auth_token_required(f):
    def decorated_function(*args, **kwargs):
        if request.headers.get('Authorization'):
            return f(*args, **kwargs)
        else:
            return 'Unauthorized', 401
    return decorated_function

@app.route('/protected', methods=['GET'])
@auth_token_required
def get_user():
    user = User.query.get(request.current_user)
    if user:
        return {'username': user.username}
    else:
        return 'User not found', 404

if __name__ == '__main__':
    app.run(debug=True)