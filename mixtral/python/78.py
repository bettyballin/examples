from flask_sqlalchemy import SQLAlchemy
from flask_security import UserMixin

db = SQLAlchemy()

class User(db.Model, UserMixin):
    id = db.Column(db.Integer, primary_key=True)
    username = db.Column(db.String(256), unique=True)

    # ... other fields

if __name__ == '__main__':
    db.create_all()