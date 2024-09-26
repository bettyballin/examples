
from flask import render_template, redirect, url_for
from flask_security import login_required, current_user

@app.route('/')
@login_required
def index():
    # If this point in the code is reached, it means that the user is authenticated.
    return render_template('index.html')

