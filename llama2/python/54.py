from flask import Flask

app = Flask(__name__)
app.config['SESSION_PROTECT'] = True

if __name__ == '__main__':
    app.run()