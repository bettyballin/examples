from flask import Flask, request, redirect, url_for
from flask_login import current_user
import sentry_sdk

app = Flask(__name__)

@app.route('/login', methods=['POST'])
def login():
    # Your authentication logic here

    with sentry_sdk.configure_scope() as scope:
        scope.user = {
            "id": current_user.get_id(),
            "email": current_user.email,
            "username": current_user.username
            # Add any additional attributes you want to send
        }

    return redirect(url_for('index'))

if __name__ == '__main__':
    app.run()