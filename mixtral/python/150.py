from app import db, create_app
from flask_security import Security, SQLAlchemyUserDatastore, encrypt_password
from .models import Role, User
from datetime import datetime

def create_user_data():
    user_role = Role(name='user')
    super_user_role = Role(name='superuser')

    db.create_all()

    data_store = SQLAlchemyUserDatastore(db, User, Role)

    admin_user = data_store.create_user(
        username='admin',
        email='admin@example.com',
        password=encrypt_password('admin'),
        confirmed_at=datetime.now(),
        roles=[user_role, super_user_role]
    )

    db.session.commit()

create_app().app_context().push()
create_user_data()