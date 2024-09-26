from flask import Flask, Response, request
from flask_login import LoginManager, UserMixin, login_required, current_user

app = Flask(__name__)
app.config['SECRET_KEY'] = 'your_secret_key'

login_manager = LoginManager()
login_manager.init_app(app)

class User(UserMixin):
    def __init__(self, id, is_admin):
        self.id = id
        self.is_admin = is_admin

@login_manager.user_loader
def load_user(user_id):
    # Replace with your actual user loading logic
    return User(user_id, True)

@app.route('/deletepost/<post_id>', methods=['POST'])
@login_required
def delete_post(post_id):
    if not current_user.is_authenticated or not current_user.is_admin:
        return Response(status=500)
    # Add your actual post deletion logic here
    return Response(status=200)

if __name__ == '__main__':
    app.run(debug=True)