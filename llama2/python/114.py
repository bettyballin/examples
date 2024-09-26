from flask import Flask, request, jsonify, make_response
from itsdangerous import SignedCookie

app = Flask(__name__)

def get_session(request):
    session = request.cookies.get('session')
    if session is None:
        session = SignedCookie(secret_key='mysecretkey', max_age=31536000)
        session['user'] = {'name': 'John Doe'}
        response = make_response(jsonify({'message': 'Welcome John Doe!'}))
        response.set_cookie('session', session.serialize())
        return session
    else:
        session = SignedCookie.unserialize(session, secret_key='mysecretkey', salt='mysecretkey')
        return session

@app.route('/', methods=['GET'])
def index():
    session = get_session(request)
    return jsonify({'session': session})

if __name__ == '__main__':
    app.run(debug=True)