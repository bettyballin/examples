from flask import Flask, current_app
from flask_login import LoginManager, UserMixin, current_user
from flask_basicauth import BasicAuth

app = Flask(__name__)
app.config['SECRET_KEY'] = 'secret_key_here'

login_manager = LoginManager(app)

class User(UserMixin):
    def __init__(self, id):
        self.id = id

@login_manager.user_loader
def user_loader(user_id):
    # Load the actual user object from your database here.
    return User(user_id)

@app.route('/protected')
@login_manager.token_loader
def protected():
    current_user_id = current_user.id  # Get the ID of the currently logged in user.
    return f'Hello, user {current_user_id}!'

if __name__ == '__main__':
    app.run(debug=True)