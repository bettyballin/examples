from flask import Flask, render_template
from flask_login import LoginManager, login_required

app = Flask(__name__)
app.config['SECRET_KEY'] = 'your_secret_key'

login_manager = LoginManager()
login_manager.init_app(app)

@app.route('/home')
@login_required
def home():
    return render_template('index.html')

if __name__ == '__main__':
    app.run(debug=True)