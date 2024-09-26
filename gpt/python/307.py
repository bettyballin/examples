
from flask_security.utils import hash_password, send_mail
from flask_security import SQLAlchemyUserDatastore

# Assuming you have User and Role models defined and imported
user_datastore = SQLAlchemyUserDatastore(db, User, Role)

@app.before_first_request
def create_user():
    db.create_all()
    user_datastore.find_or_create_role(name='admin', description='Administrator')
    user_datastore.find_or_create_role(name='office_owner', description='Office owner')
    
    if not user_datastore.get_user('test@gmail.com'):
        user = user_datastore.create_user(email='test@gmail.com', password=hash_password('password'))
        db.session.commit()  # Commit after user creation

        # Now send email
        send_welcome_email(user)

def send_w
