
import sentry_sdk
from flask import Flask
from flask_login import current_user
from sentry_sdk.integrations.flask import FlaskIntegration

sentry_sdk.init(
    dsn="your_dsn_here",
    integrations=[FlaskIntegration()],
    send_default_pii=True
)

app = Flask(__name__)

# ... your Flask app setup ...

@app.before_request
def before_request():
    with sentry_sdk.configure_scope() as scope:
        if current_user.is_authenticated:
            # Set additional user information here
            scope.set_user({
                "id": current_user.get_id(),   # User's unique ID
                "email": current_user.email,   # User's email address
                # Add any additional fields you want to track
                "
