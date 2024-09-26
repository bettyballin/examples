from flask import Flask, make_response

app = Flask(__name__)

@app.route('/')
def index():
    response = make_response('Hello, World!')
    response.headers['Server'] = "None of your beeswax!"
    return response

if __name__ == '__main__':
    app.run()