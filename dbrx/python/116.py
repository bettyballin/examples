from .models import db, user_datastore
from flask import create_app
from .views.login import bcrypt

def create_admin_user():
    admin_role = user_datastore.find_or_create_role('admin')
    admin_user = user_datastore.find_or_create_user(email='admin@example.com', password=bcrypt.generate_password_hash('admin').decode('utf-8'))
    user_datastore.add_role_to_user(admin_user, admin_role)
    db.session.commit()

if __name__ == '__main__':
    app = create_app()
    with app.app_context():
        db.create_all()
        create_admin_user()