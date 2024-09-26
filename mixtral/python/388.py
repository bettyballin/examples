import unittest
from app import create_app, db
from app.models import User, Role
from app.config import TestConfig

class UserModelCase(unittest.TestCase):
    def setUp(self):
        self.app = create_app(TestConfig)

        # Create the database tables
        with self.app.test_request_context():
            db.create_all()