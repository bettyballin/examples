from flask import Flask, request

app = Flask(__name__)

@app.before_request
def silent_mode():
    if request.path == '/':
        return '444'

if __name__ == '__main__':
    app.run(debug=True)