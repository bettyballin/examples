from flask import Flask, request, redirect, url_for

app = Flask(__name__)

def login(client):
    return client.post('/login', data=dict(
        email='testuser@example.com',
        password='password'
    ), follow_redirects=True)

@app.route('/login', methods=['POST'])
def login_route():
    email = request.form['email']
    password = request.form['password']
    # Add your login logic here
    return redirect(url_for('index'))

@app.route('/')
def index():
    return 'Logged in!'

with app.test_request_context():
    response = login(app.test_client())