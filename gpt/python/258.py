
# Create a user to test with
@app.before_first_request
def create_user():
    db.create_all()
    if not user_datastore.get_user('matt@nobien.net'):
        hashed_password = security.password_hasher.hash('password')
        user_datastore.create_user(email='matt@nobien.net', password=hashed_password)
        db.session.commit()

