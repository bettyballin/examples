from flask import Flask, request, g
from flask_admin import Admin
from flask_admin.contrib.sqla import ModelView as AdminModelView
from flask_sqlalchemy import SQLAlchemy
from flask_security import UserMixin, RoleMixin, SQLAlchemyUserDatastore, Security

app = Flask(__name__)
app.config['SECRET_KEY'] = 'secret_key_here'
app.config['SQLALCHEMY_DATABASE_URI'] = 'sqlite:///example.db'

db = SQLAlchemy(app)

roles_users = db.Table('roles_users',
    db.Column('user_id', db.Integer(), db.ForeignKey('user.id')),
    db.Column('role_id', db.Integer(), db.ForeignKey('role.id'))
)

class Role(db.Model, RoleMixin):
    id = db.Column(db.Integer, primary_key=True)
    name = db.Column(db.String(80), unique=True)
    description = db.Column(db.String(255))

class User(db.Model, UserMixin):
    id = db.Column(db.Integer, primary_key=True)
    email = db.Column(db.String(255), unique=True)
    password = db.Column(db.String(255))
    active = db.Column(db.Boolean())
    confirmed_at = db.Column(db.DateTime())
    roles = db.relationship('Role', secondary=roles_users,
                            backref=db.backref('users', lazy='dynamic'))

class MyModel(db.Model):
    id = db.Column(db.Integer, primary_key=True)
    password = db.Column(db.String(255))

class MyModelView(AdminModelView):
    def __init__(self, *args, **kwargs):
        super(MyModelView, self).__init__(*args, **kwargs)
        if not hasattr(g, 'current_user'):
            # Set the current user in a global variable
            g.current_user = request.user

    @property
    def form_args(self):
        args = {}
        for field_name in self.model.__mapper__.columns.keys():
            if field_name == 'password' and not g.current_user.has_role('admin'):
                continue  # Skip the password field for non-admin users
            args[field_name] = {'label': field_name}
        return args

admin = Admin(app, name='My App', template_folder='templates/admin')
admin.add_view(MyModelView(MyModel, db.session))

user_datastore = SQLAlchemyUserDatastore(db, User, Role)
security = Security(app, user_datastore)

if __name__ == '__main__':
    app.run(debug=True)