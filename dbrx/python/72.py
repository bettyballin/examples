import time
from flask import Flask
from itsdangerous import TimedSerializer
from datetime import timedelta

app = Flask(__name__)
app.config['SECRET_KEY'] = 'your_secret_key_here'

user = type('User', (), {'id': 1})  # dummy user object

s = TimedSerializer(app.config['SECRET_KEY'], expires_in=timedelta(hours=1).total_seconds())
token = s.dumps({'id': user.id, 'timestamp': int(time.time())})

print(token)