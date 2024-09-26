from flask import Flask
from flask_security import Security, SQLAlchemyUserDatastore
from flask_sqlalchemy import SQLAlchemy

app = Flask(__name__)
app.config['SQLALCHEMY_DATABASE_URI'] = 'sqlite:///database.db'
db = SQLAlchemy(app)

app.config['SECURITY_USERNAME_ENABLED'] = True
app.config['SECURITY_USER_IDENTITY_ATTRIBUTES'] = ['username']

# The following is needed to make the code executable
if __name__ == '__main__':
    app.run(debug=True)