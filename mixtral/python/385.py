from datetime import timedelta
from flask import Flask
from flask_mail import Mail, Message
from itsdangerous import URLSafeTimedSerializer

app = Flask(__name__)
app.config['SECRET_KEY'] = 'SECRET'
app.config['MAIL_SERVER'] = 'smtp.example.com'
app.config['MAIL_PORT'] = 587
app.config['MAIL_USE_TLS'] = True
app.config['MAIL_USERNAME'] = 'your-email@example.com'
app.config['MAIL_PASSWORD'] = 'your-password'

mail = Mail(app)

def send_newsletter(user):
    # Generate a one-time token for unsubscribing
    serializer = URLSafeTimedSerializer(app.config['SECRET_KEY'])

    data = {'email': user.email}

    expiration = timedelta(days=1)

    token = serializer.dumps(data, salt='unsubscribe-salt', expires_in=expiration)

    # Create the unsubscription link

    url = f'https://example.com/newsletter?token={token}'

    msg = Message('Weekly Newsletter!', sender='your-email@example.com', recipients=[user.email])

    msg.body = f"""Here is your weekly newsletter!

{url}"""

    mail.send(msg)

if __name__ == '__main__':
    app.run(debug=True)