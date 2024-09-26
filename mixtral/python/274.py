from flask import Flask, render_template
from flask_mail import Mail, Message
from flask_security import SQLAlchemyUserDatastore, hash_password

app = Flask(__name__)
app.config['SECRET_KEY'] = 'secret_key_here'
app.config['SQLALCHEMY_DATABASE_URI'] = 'sqlite:///database.db'
app.config['MAIL_SERVER'] = 'smtp.gmail.com'
app.config['MAIL_PORT'] = 587
app.config['MAIL_USE_TLS'] = True
app.config['MAIL_USERNAME'] = 'your-email@example.com'
app.config['MAIL_PASSWORD'] = 'your_email_password'

db = SQLAlchemy(app)
mail = Mail(app)

from .models import User, Role
user_datastore = SQLAlchemyUserDatastore(db, User, Role)

@app.before_first_request
def create_user():
    db.create_all()

    # Create the Roles "admin" and "office_owner" -- unless they already exist
    user_datastore.find_or_create_role('admin', description='Administrator')
    user_datastore.find_or_create_role('office_owner', description='Office owner')

    if not user_datastore.get_user('test@gmail.com'):
        new_user = user_datastore.create_user(email='test@gmail.com', password=hash_password('password'))

        # Commit any database changes; the User and Roles must exist before we can add a Role to the User
        db.session.commit()

        send_welcome_mail(new_user)

def send_welcome_mail(user):
    msg = Message('Welcome!', sender='your-email@example.com', recipients=[user.email])

    # You can use a template to create the email body
    msg.body = render_template('emails/welcome.txt', user=user)

    mail.send(msg)

if __name__ == '__main__':
    app.run(debug=True)