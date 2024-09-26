from flask import Flask, session, redirect, url_for

app = Flask(__name__)
app.secret_key = 'super secret key'

@app.route('/')
def index():
    if 'username' in session:
        return f"Logged in as {session['username']}"
    else:
        return redirect(url_for('login'))

@app.route('/login')
def login():
    # Implement your login logic here
    session['username'] = 'username'
    return 'Logged in successfully'

if __name__ == '__main__':
    app.run(debug=True)