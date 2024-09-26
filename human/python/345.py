# conftest.py
import pytest
from yourapp import create_app, Testing
from flask_login import FlaskLoginClient

@pytest.fixture
def app():
    app = create_app(Testing)
    app.test_client_class = FlaskLoginClient
    yield app


# test_basic.py
from yourapp import User

def test_login(app):
    user = User.query.filter_by(email='testuser@example.com').one()
    with app.test_client(user=user) as client:
        resp = client.get('/', follow_redirects=True)
        assert resp.status_code == 200


bash
# Run the test
pytest test_basic.py