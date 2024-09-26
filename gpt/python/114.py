
from flask import Flask, request, jsonify
from flask_security import Security, SQLAlchemyUserDatastore, UserMixin, RoleMixin, utils
from flask_sqlalchemy import SQLAlchemy

# Initialize Flask and its extensions
app = Flask(__name__)
app.config['SECRET_KEY'] = 'your-secret-key'
app.config['SQLALCHEMY_DATABASE_URI'] = 'your-database-uri'
app.config['SECURITY_PASSWORD_SALT'] = 'your-password-salt'

db = SQLAlchemy(app)

# Define models
roles_users = db.Table('roles_users',
        db.Column('user_id', db.Integer(), db.ForeignKey('user.id')),
        db.Column('role_id', db.Integer(), db.ForeignKey('role.id')))

class Role(db.Model, RoleMixin):
    id = db.Column(db.Integer(), primary_key=True)
    name = db.Column(db.String(80), unique=True
