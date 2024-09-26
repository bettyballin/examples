
import pytest
from flask import session
from racesupportcontracts import create_app, user_datastore
from racesupportcontracts.dbmodel import db, init_db, User
from racesupportcontracts.settings import Testing
from flask_security.utils import login_user as fs_login_user

@pytest.fixture
def app():
    app = create_app(Testing)
    with app.app_context():
        db.init_app(app)
        db.create_all
