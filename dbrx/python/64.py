from flask import Flask, request, session

app = Flask(__name__)
app.config["SECRET_KEY"] = "secret_key_here"

@app.before_request
def check_session():
    if 'try_number' in session and session['try_number'] != 2:
        return "Invalid try number", 401
    elif 'try_number' not in session:
        return "No try number in session", 401