from flask import Flask
from flask_sqlalchemy import SQLAlchemy
from model.base import Base

app = Flask(__name__)
app.config['SQLALCHEMY_DATABASE_URI'] = 'sqlite:////tmp/test.db' # add your database URI
db = SQLAlchemy(app, model_class=Base)

if __name__ == '__main__':
    app.run(debug=True)