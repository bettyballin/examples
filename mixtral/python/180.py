from flask import Flask, redirect, url_for
from flask_login import UserMixin, login_required, current_user
from flask_sqlalchemy import SQLAlchemy

app = Flask(__name__)
app.config['SECRET_KEY'] = 'secret_key'
app.config['SQLALCHEMY_DATABASE_URI'] = 'sqlite:///database.db'
db = SQLAlchemy(app)

class User(db.Model, UserMixin):
    # ...

    def is_admin(self):
        return self.isUser == "Yes"

#...

@app.route('/addMovie/', methods=['GET', 'POST'])
@login_required
def addMovie():
     if not current_user.is_authenticated or not current_user.is_admin():
         error = "You must have Admin Privileges to add a Movie/TV Show"
         return redirect(url_for('index'))

     # ...