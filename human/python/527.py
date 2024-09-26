from flask import Flask, make_response

app = Flask(__name__)

@app.route("/")
def index():
    response = make_response("Hello, World!")
    response.headers.set("Content-Security-Policy", "default-src 'self'; script-src 'self' https://cdn.example.com;")
    return response

if __name__ == "__main__":
    app.run()