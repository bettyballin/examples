from app import create_app, db
from app.models import User, Role
from flask_security.utils import encrypt_password

def setup():
    app = create_app()

    with app.app_context():
        db.create_all()

        user_role = Role(name='user')
        db.session.add(user_role)
        db.session.commit()

if __name__ == '__main__':
    setup()