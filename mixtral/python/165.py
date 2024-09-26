from flask import Flask
from flask_mail import Mail, Message

app = Flask(__name__)
app.config['MAIL_SERVER'] = 'smtp.gmail.com'
app.config['MAIL_PORT'] = 465
app.config['MAIL_USE_TLS'] = False
app.config['MAIL_USE_SSL'] = True
app.config['MAIL_USERNAME'] = 'your-email@example.com'
app.config['MAIL_PASSWORD'] = 'your-email-password'

mail = Mail(app)

@app.route('/send')
def send():
    msg = Message('Hello',
                  sender='your-email@example.com',
                  recipients=['recipient1@example.com'])

    mail.send(msg)
    return 'Sent'

if __name__ == '__main__':
    app.run(debug=True)