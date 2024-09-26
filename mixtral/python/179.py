from flask import Flask, render_template, current_app
from flask_login import LoginManager, login_required, current_user

app = Flask(__name__)
login_manager = LoginManager(app)

@app.route('/')
@login_required
def index():
    if not current_user.is_authenticated:
        return current_app.login_manager.unauthorized()

    return render_template('index.html', user=current_user)

if __name__ == '__main__':
    app.run(debug=True)