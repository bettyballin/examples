from flask import Flask, jsonify
from http import HTTPStatus

app = Flask(__name__)

@app.route('/')
def empty_view():
    content = {'please move along': 'nothing to see here'}
    return jsonify(content), HTTPStatus.GONE

if __name__ == '__main__':
    app.run()