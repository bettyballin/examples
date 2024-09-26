from racesupportcontracts import create_app, db, init_db, User

def login_test_user(app, email):
    with app.app_context():
        from flask_security import current_user, login_user
        user = User.query.filter_by(email=email).one()
        assert not current_user.is_authenticated  # check if no one is logged in before logging in test user
        login_user(user)
        db.session.commit()

def create_test_user(app):
    with app.app_context():
        from racesupportcontracts import user_datastore, Role
        role = Role.query.filter_by(name='superadmin').first()
        assert role  # check if superadmin role exists before creating a test user
        return user_datastore.create_user(email='testuser@example.com', password='password1234', roles=[role])

def test_login(dbapp):
    app = create_app()
    app.config['TESTING'] = True
    app.config['WTF_CSRF_ENABLED'] = False
    db.init_app(app)
    with app.app_context():
        init_db(defineowner=False)
    create_test_user(app)  # creates and returns the created test user object

    with app.test_client() as client:
        login_test_user(app, 'testuser@example.com')  # logs in using email of previously created test user
        resp = client.get('/', follow_redirects=True)
        assert resp.status_code == 200
        from flask_security import logout_user
        logout_user()

if __name__ == '__main__':
    test_login(None)