from flask import Flask, request, redirect, url_for
from flask_login import LoginManager, UserMixin, login_user, logout_user, login_required, current_user
from flask.signals import Namespace

app = Flask(__name__)
app.config['SECRET_KEY'] = 'secret_key_here'

login_manager = LoginManager()
login_manager.init_app(app)

class User(UserMixin):
    def __init__(self, id):
        self.id = id

    def get_auth_token(self):
        return "auth_token_here"

@login_manager.user_loader
def load_user(user_id):
    return User(user_id)

def log_auth_token(token):
    print(f"Logged in with token: {token}")

namespace = Namespace()
user_logged_in = namespace.signal('logged_in')

@user_logged_in.connect_via(app)
def on_user_logged_in(sender, user):
    log_auth_token(user.get_auth_token())

@app.route('/login')
def login():
    user = User(1)
    login_user(user)
    return redirect(url_for('protected'))

@app.route('/protected')
@login_required
def protected():
    on_user_logged_in(app, current_user)
    return 'Hello, World!'

if __name__ == '__main__':
    app.run(debug=True)