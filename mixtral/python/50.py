from flask import Flask, request, jsonify
from werkzeug.security import check_password_hash

app = Flask(__name__)

# assuming UserDatastore is defined elsewhere
from yourmodule import UserDatastore

@app.route('/api/login', methods=['POST'])
def api_login():
    email = request.json["email"]
    password = request.json["password"]
    user = UserDatastore.find_user(email=email)
    if not user or not check_password_hash(user.password, password):
        return jsonify({"msg": "Bad email or password"})