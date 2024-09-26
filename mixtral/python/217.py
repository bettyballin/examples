from yourapp import app, db
from yourapp.models import User
from flask_login import login_user

with app.test_request_context():
    useremail = 'example@example.com'  # replace with actual email
    user = User.query.filter_by(email=useremail).one()
    login_user(user)
db.session.commit()