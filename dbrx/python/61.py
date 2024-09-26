from sqlalchemy.orm import Query
from sqlalchemy.ext.declarative import declarative_base
from flask import Flask
from flask_sqlalchemy import SQLAlchemy

app = Flask(__name__)
app.config["SQLALCHEMY_DATABASE_URI"] = "sqlite:///:memory:"
db = SQLAlchemy(app)

Base = declarative_base()

class CustomQuery(Query):
    def __init__(self, entities, session=None):
        super(CustomQuery, self).__init__(entities)
        if not session:
            session = db.session
        self.session = session

class Post(Base):
    __tablename__ = 'posts'
    id = db.Column(db.Integer, primary_key=True)
    query_class = CustomQuery

Base.metadata.create_all(db.engine)

# Example usage:
post = Post()
db.session.add(post)
db.session.commit()

result = Post.query.all()
print(result)