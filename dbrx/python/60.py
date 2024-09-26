from flask import Flask
from flask_sqlalchemy import SQLAlchemy

app = Flask(__name__)
app.config['SQLALCHEMY_DATABASE_URI'] = 'sqlite:////tmp/test.db'
db = SQLAlchemy(app)

class Post(db.Model):
    __tablename__  =  'Posts' 
    id  = db.Column(db.Integer, primary_key=True, autoincrement=True)
    body  = db.Column(db.Text) 
    timestamp  = db.Column(db.DateTime) 
    user_id  = db.Column(db.Integer, db.ForeignKey('Users.uid'))

if __name__ == '__main__':
    app.run()