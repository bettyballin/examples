from flask import Flask
from flask_sqlalchemy import SQLAlchemy
from flask_login import UserMixin, current_user
from flask_admin import Admin
from flask_admin.contrib.sqla import ModelView
from sqlalchemy import func

app = Flask(__name__)
app.config['SQLALCHEMY_DATABASE_URI'] = 'sqlite:///database.db'
db = SQLAlchemy(app)
admin = Admin(app)

class User(db.Model, UserMixin):
    id = db.Column(db.Integer, primary_key=True)
    first_name = db.Column(db.String(255))
    last_name = db.Column(db.String(255))
    email = db.Column(db.String(255), unique=True)
    password = db.Column(db.String(255))

    def __str__(self):
        return self.email

    @property
    def is_admin(self):
        # Customize this logic based on your application's requirements.
        return self.id == 1 or 'admin' in [role.name for role in current_user.roles]

class UserView(ModelView):
    """Restrict only the user can see his/her own profile unless they are admin."""

    def get_query(self):
        if not current_user.is_admin:
            query = super().get_query().filter(self.model.id == current_user.id)
        else:  # Admin users should be able to view all profiles.
            query = self.session.query(self.model)
        return query

    def get_count_query(self):
        if not current_user.is_admin:
            count_query = super().get_count_query().filter(self.model.id == current_user.id)
        else:  # Count the total number of records for admin user.
            count_query = self.session.query(func.count('*')).select_from(self.model)
        return count_query

admin.add_view(UserView(User, db.session))

if __name__ == '__main__':
    db.create_all()
    app.run(debug=True)