from flask import Flask, request, jsonify
from flask_login import LoginManager, login_user, login_required
from flask_sqlalchemy import SQLAlchemy
from werkzeug.security import check_password_hash, generate_password_hash

app = Flask(__name__)
app.config['SECRET_KEY'] = 'your-secret-key'
app.config['SQLALCHEMY_DATABASE_URI'] = 'sqlite:///your-database.db'
db = SQLAlchemy(app)
login_manager = LoginManager(app)

class User(db.Model):
    id = db.Column(db.Integer, primary_key=True)
    username = db.Column(db.String(80), unique=True, nullable=False)
    password = db.Column(db.String(120), nullable=False)

    def __init__(self, username, password):
        self.username = username
        self.password = generate_password_hash(password)

    def __repr__(self):
        return '<User %r>' % self.username

@login_manager.user_loader
def load_user(user_id):
    return User.query.get(int(user_id))

def generate_token(user):
    # Your token generation logic here...
    return 'token-for-' + user.username

@app.route('/api/register', methods=['POST'])
def register():
    if not request.json or 'username' not in request.json or 'password' not in request.json:
        return jsonify({'error': 'Invalid request'}), 400
    user = User(username=request.json['username'], password=request.json['password'])
    db.session.add(user)
    db.session.commit()
    return jsonify({'message': 'User created successfully'})

@app.route('/api/login', methods=['POST'])
def login():
    username = request.json.get('username')
    password = request.json.get('password')
    user = User.query.filter_by(username=username).first()
    if not user or not check_password_hash(user.password, password):
        return jsonify({'error': 'Invalid credentials'}), 401
    login_user(user)
    return jsonify({'token': generate_token(user)})

@app.route('/api/protected', methods=['GET'])
@login_required
def protected():
    return jsonify({'message': 'Hello, protected world!'})

if __name__ == '__main__':
    db.create_all()
    app.run(debug=True)