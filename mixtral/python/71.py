from flask import Flask
from flask_sqlalchemy import SQLAlchemy
from sqlalchemy.ext.declarative import declarative_base

app = Flask(__name__)

# Configure your app
app.config['SQLALCHEMY_BINDS'] = {
    'db1': 'sqlite:////tmp/test1.db',
    'db2': 'postgresql+psycopg2://user:password@localhost/mydatabase'
}

# Create the SQLAlchemy object
db = SQLAlchemy(app)

Base = declarative_base()

class Post(db.Model):
   __tablename__ = 'posts'
   __table_args__ = {'autoload': True, 'bind_key': 'db1'}

@app.route('/')
def index():
    posts = Post.query.all()
    return 'Posts: {}'.format(posts)

if __name__ == '__main__':
    app.run(debug=True)