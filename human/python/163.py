from flask import Flask
from flask_sqlalchemy import SQLAlchemy

app = Flask(__name__)
app.config['SQLALCHEMY_DATABASE_URI'] = 'sqlite:////tmp/test.db'
db = SQLAlchemy(app)

class Base(db.Model):
    pass

base = Base
db.register_base(base)

if __name__ == '__main__':
    app.run(debug=True)