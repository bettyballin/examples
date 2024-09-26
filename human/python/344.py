import unittest
from yourapp import app

class TestYourApp(unittest.TestCase):

    def test_your_test(self):
        with app.test_client() as client:
            with client.session_transaction() as sess:
                sess["user_id"] = 1  # if you want user 1 to be logged in for this test

            resp = client.get('/', follow_redirects=True)
            # make whatever assertions you want
            self.assertEqual(resp.status_code, 200)

if __name__ == '__main__':
    unittest.main()