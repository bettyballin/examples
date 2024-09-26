from werkzeug.local import LocalProxy
from flask import current_app

_default_config = {
    # ...
    'EMAIL_SENDER': LocalProxy(lambda: current_app.config.get(
        'MAIL_DEFAULT_SENDER', 'no-reply@localhost.com'
    )),
}