from flask import Flask
from flask_login import LoginManager
from flask_security import Security
from flask_wtf import CSRFProtect

app = Flask(__name__)
app.config['SECRET_KEY'] = 'secret_key_here'

login_manager = LoginManager(app)
csrf = CSRFProtect(app)

if __name__ == '__main__':
    app.run(debug=True)