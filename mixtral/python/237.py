import jwt
from flask import Flask, request

app = Flask(__name__)

SECRET = 'your-secret-key'

def verify_token(func):
    def wrapper(*args, **kwargs):
        token = request.headers.get('Authorization')

        try:
            decoded = jwt.decode(token, SECRET, algorithms=['HS256'])

            # You can also check the 'exp' claim to see if it has expired

            return func(*args, **kwargs)

        except Exception as e:

            print('Invalid token')
            return 'Invalid token', 401

    return wrapper

@app.route('/do_stuff', methods=['GET'])
@verify_token
def do_stuff():

   # Your code here
   return 'Token is valid'

if __name__ == '__main__':
    app.run(debug=True)