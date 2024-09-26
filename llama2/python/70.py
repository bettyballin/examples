from flask import Flask, redirect, url_for
from flask_security import login_user, logout_user, login_required, current_user
from functools import wraps

app = Flask(__name__)
app.config['SECRET_KEY'] = 'secret_key_here'

def authenticated_only(f):
    @wraps(f)
    def decorator(*args, **kwargs):
        if not current_user.is_authenticated:
            return redirect(url_for('landing'))
        return f(*args, **kwargs)
    return decorator

@app.route('/')
@authenticated_only
def index():
    # render template or do something else for authenticated users
    return 'Hello, authenticated user!'

@app.route('/landing')
def landing():
    return 'You are not authenticated. Please login.'

if __name__ == '__main__':
    app.run(debug=True)