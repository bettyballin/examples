from flask import current_app

default_sender = lambda: current_app.config.get('MAIL_DEFAULT_SENDER', 'no-reply@localhost.com')
print(default_sender())