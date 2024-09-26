from flask import Flask
from flask_sqlalchemy import SQLAlchemy
from sqlalchemy.ext.declarative import declarative_base

app = Flask(__name__)

# Configure your app
app.config['SQLALCHEMY_DATABASE_URI'] = 'sqlite:////tmp/test.db'

# Create the SQLAlchemy object
db = SQLAlchemy(app)
Base = declarative_base()

class Post(Base):
    __tablename__ = 'Posts'
    __table_args__ = {'autoload': True}

@app.route('/')
def index():
   posts = Post.query.all()
   return [post.__dict__ for post in posts]

if __name__ == '__main__':
    app.run(debug=True)