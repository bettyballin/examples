import flask_login
import sentry_sdk
from sentry_sdk.integrations.flask import FlaskIntegration

def before_send(event, hint):
    try:
        user = flask_login.current_user
        user_info = event.setdefault("user", {})
        user_info["myattribute"] = user.myattribute
    except Exception:
        pass
    return event

sentry_sdk.init(
    dsn="your_dsn_here",
    integrations=[FlaskIntegration()],
    before_send=before_send
)