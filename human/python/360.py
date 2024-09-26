from flask import request
from flask_login import login_user
from flask_security import verify_password, after_this_request, flask_security_datastore_commit

@app.route('/login', methods=['POST'])
def login():
    user = User.query.filter_by(email=request.form['email']).first()
    if verify_password(request.form['password'], user.password):
        login_user(user)
        after_this_request(flask_security_datastore_commit)
        return "Logged in"