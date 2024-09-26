from flask import Flask, request, redirect, url_for
from flask_login import login_required, current_user
from functools import wraps

app = Flask(__name__)

def is_admin(f):
    @wraps(f)
    def decorated_function(*args, **kwargs):
        if current_user.role != 'admin':
            return redirect(url_for('index'))
        return f(*args, **kwargs)
    return decorated_function

@app.route('/deletepost/<int:post_id>', methods=['POST'])
@login_required
@is_admin
def delete_post(post_id):
    # do something
    pass