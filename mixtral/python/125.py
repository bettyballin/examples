from flask import Flask, render_template, redirect, url_for, request
from flask_login import LoginManager, current_user, login_required

app = Flask(__name__)
app.config['SECRET_KEY'] = 'your_secret_key_here'

login_manager = LoginManager(app)

@app.route('/')
@login_required
def index():
    return render_template('index.html')

@app.before_request
def before_request():
    if not current_user.is_anonymous and request.endpoint != 'static':
        url = request.path
        if (url == '/') or (current_user.is_authenticated):
            return render_template('index.html'), 200
    elif current_user.is_anonymous and request.endpoint != 'static':
        return None

@app.route('/landing', defaults={'path': ''})
def landing(path):
    if current_user.is_anonymous and request.endpoint != 'static' or not (current_user.has_role('admin') or current_user.has_permission("VIEW")):
        return render_template('landing.html'), 200

@app.before_request
def before_request_auth():
    if not (current_user and ((current_user.has_role("admin") or current_user.has_permission('VIEW')))):
        return redirect(url_for('landing', path=request.path))

if __name__ == '__main__':
    app.run(debug=True)