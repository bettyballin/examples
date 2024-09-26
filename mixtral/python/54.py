from flask import Flask, current_app
from flask_login import LoginManager, current_user

app = Flask(__name__)
app.config['SECRET_KEY'] = 'secret_key_here'
login_manager = LoginManager(app)

@login_manager.user_loader
def load_user(id):
    # Your existing code here
    pass

@app.before_request
def before_request():
    if not current_user.is_authenticated:
        return

@login_manager.token_loaded.connect_via(app)
def handle_token(sender, token):
    # Your custom code here
    pass

if __name__ == '__main__':
    app.run()