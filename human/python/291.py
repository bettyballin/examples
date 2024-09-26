from flask import Flask, render_template, abort
from flask_login import current_user, login_required, LoginManager
from models import User  # Assuming you have a User model defined elsewhere

app = Flask(__name__)
app.config['SECRET_KEY'] = 'your_secret_key_here'
login_manager = LoginManager(app)

@login_manager.user_loader
def load_user(id):
    return User.query.get(int(id))

def require_admin():
    if not current_user.isAdmin:
        abort(403)

@app.errorhandler(403)
def error_access_forbidden(error):
    error_code = 403
    error_message = "Sorry, access denied or forbidden!"
    return render_template('4xx.html',
                           error_code = error_code,
                           error_message=error_message), 403

@app.route('/addMovie', methods=['GET', 'POST'])
@login_required
def addMovie():
    require_admin()
    error = None
    return render_template('addMovie.html', error=error)

if __name__ == '__main__':
    app.run(debug=True)