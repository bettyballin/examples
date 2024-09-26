import unittest
from your_app import create_app, db
from your_app.config import TestConfig

class UserModelCase(unittest.TestCase):
    def setUp(self):
        db.metadata.clear()  # Clear existing metadata to avoid conflicts between tests
        self.app = create_app(TestConfig)
        self.app_context = self.app.app_context()
        self.app_context.push()
        db.create_all()

    def tearDown(self):
        db.session.remove()
        db.drop_all()
        self.app_context.pop()

if __name__ == '__main__':
    unittest.main()