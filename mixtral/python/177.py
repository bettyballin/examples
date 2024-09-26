from flask import Flask, g
from flask_login import LoginManager, current_user

app = Flask(__name__)
app.config['SECRET_KEY'] = 'your-secret-key'

# Initialize login manager
login_manager = LoginManager(app)

@app.before_request
def before_request():
    # This is required to make current_user available in templates
    if current_user.is_authenticated:
        g.current_user = current_user

if __name__ == '__main__':
    app.run(debug=True)