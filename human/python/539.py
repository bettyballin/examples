from flask import Flask, render_template
from flask_login import LoginManager, current_user

app = Flask(__name__)
app.config['SECRET_KEY'] = 'secret_key_here'

login_manager = LoginManager(app)

@app.route("/roles")
def my_route():
    return render_template("roles.html", current_user=current_user, roles=current_user.roles)

if __name__ == "__main__":
    app.run(debug=True)