import sentry_sdk
from flask import Flask, g
from flask_login import current_user

sentry_sdk.init(
    dsn="your_dsn_here",
    send_default_pii=True
)

def add_extra_user_data(event, hint):
    if 'user' not in event:
        return event

    user = event['user']
    current_user = getattr(g, 'current_user', None)
    
    # Add any extra attributes you want here
    user.update({
        'username': current_user.username
    })

    return event

sentry_sdk.add_event_processor(add_extra_user_data)

app = Flask(__name__)

@app.before_request
def set_current_user():
    g.current_user = current_user