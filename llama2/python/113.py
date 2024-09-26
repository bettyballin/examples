from flask import Flask
from flask_session import Session

MyApp = Flask(__name__)
MyApp.config['SESSION_COOKIE_SECURE'] = True
MyApp.config['SESSION_COOKIE_HTTPONLY'] = True
MyApp.config['SESSION_COOKIE_SAMESITE'] = 'Strict'
MyApp.config['SESSION_TYPE'] = 'filesystem'
MyApp.config['SESSION_PERMANENT'] = False
MyApp.config['SESSION_USE_SIGNER'] = True
MyApp.config['SECRET_KEY'] = 'secret_key_here'
MyApp.config['SESSION_KEY_PREFIX'] = 'secure'
MyApp.config['SESSION_COOKIE_NAME'] = 'session'
MyApp.config['PERMANENT_SESSION_LIFETIME'] = 300

Session(MyApp)

if __name__ == '__main__':
    MyApp.run(debug=True)