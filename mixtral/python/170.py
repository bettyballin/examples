from flask import Flask, request
from flask_sqlalchemy import SQLAlchemy
from werkzeug.security import generate_password_hash
from flask_security import logout_user

app = Flask(__name__)
app.config['SQLALCHEMY_DATABASE_URI'] = 'sqlite:///my_database.db'
db = SQLAlchemy(app)

class MyUser(db.Model):
    id = db.Column(db.Integer, primary_key=True)
    password = db.Column(db.String(255), nullable=False)

    def reset_password(self, new_password):
        self.password = generate_password_hash(new_password)

        db.session.commit()

        logout_user()  # Prevent automatic login

# Update the User model in Flask-Security
User = MyUser

if __name__ == '__main__':
    app.run(debug=True)