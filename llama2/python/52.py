from flask import Flask
from flask_sqlalchemy import SQLAlchemy

app = Flask(__name__)
app.config['SQLALCHEMY_DATABASE_URI'] = 'sqlite:///mydatabase.db'
db = SQLAlchemy(app)

class MyModel(db.Model):
    __tablename__ = 'mytable'
    id = db.Column(db.Integer, primary_key=True)
    name = db.Column(db.String(80), unique=True)

class User(MyModel):
    email = db.Column(db.String(120), unique=True)

@app.before_first_request
def create_tables():
    db.create_all()

@app.route('/')
def index():
    user = User.query.first()
    if user is None:
        user = User(name='John Doe', email='john@example.com')
        db.session.add(user)
        db.session.commit()
    return 'Hello {}!'.format(user.name)

if __name__ == '__main__':
    app.run(debug=True)