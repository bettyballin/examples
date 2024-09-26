from flask import Flask, request

app = Flask(__name__)

@app.before_request
def check_silent():
    if "/" in request.path and not request.is_xhr:
        return " ", 204

# Define your Flask app's routes here

if __name__ == "__main__":
    app.run()