from flask import Flask, abort

app = Flask(__name__)

@app.route('/')
def home():
    abort(204)

if __name__ == '__main__':
    app.run()