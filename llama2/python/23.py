from flask import Flask, current_app, request
from flask_login import LoginManager, UserMixin, login_required, current_user

app = Flask(__name__)
app.config['SECRET_KEY'] = 'secret_key_here'

class MyUser(UserMixin):
    def __init__(self, user_id, token):
        self.user_id = user_id
        self.token = token
        self.name = "John Doe"  # Add a name attribute for demonstration purposes

@login_manager.user_loader
def load_user(user_id):
    # Use the user's ID to load their information from the database
    # For demonstration purposes, we'll just return a new MyUser object
    return MyUser(user_id, "token_here")

@app.route('/')
@login_required
def index():
    # Use the user's ID and token to load their information from the database
    return 'Hello {}!'.format(current_user.name)

login_manager = LoginManager()
login_manager.init_app(app)

if __name__ == '__main__':
    app.run(debug=True)