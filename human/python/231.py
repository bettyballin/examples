from flask import Flask
from flask_admin import Admin
from flask_admin.contrib.sqla import ModelView
from flask_sqlalchemy import SQLAlchemy

app = Flask(__name__)
app.config['SQLALCHEMY_DATABASE_URI'] = 'sqlite:///example.db'
db = SQLAlchemy(app)

admin = Admin(app, name='example', template_folder='templates/admin')

class User(db.Model):
    id = db.Column(db.Integer, primary_key=True)
    first_name = db.Column(db.String(100))
    last_name = db.Column(db.String(100))
    email = db.Column(db.String(100))
    active = db.Column(db.Boolean)
    roles = db.Column(db.String(100))

class AdminView(ModelView):
    pass

class AdminUserView(AdminView):
    column_list = ['first_name', 'last_name', 'email', 'roles', 'active']
    form_columns = ['first_name', 'last_name', 'email', 'active', 'roles']

class UserView(AdminUserView):
    column_list = ['first_name', 'last_name', 'email', 'roles']
    form_columns = ['first_name', 'last_name', 'email', 'roles']

admin.add_view(AdminUserView(model=User, session=db.session, category="Accounts", name="Users", endpoint="users_admin", roles_accepted=["admin"]))
admin.add_view(UserView(model=User, session=db.session, category="Accounts", name="Users", endpoint="users_user", roles_accepted=["user"]))

if __name__ == '__main__':
    app.run(debug=True)