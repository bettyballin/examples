from flask import Flask, request
from flask_restx import Resource, Api

app = Flask(__name__)
flask_api = Api(app)

def token_decorator(func):
    def wrapper(*args, **kwargs):
        # Your token validation logic here
        return func(*args, **kwargs)
    return wrapper

class GetArticle(Resource):
    @token_decorator
    def get(self, title=None, id=None):
        # Your logic to handle GET request
        pass

article_manager = flask_api.namespace('article', description='Article operations')
article_manager.add_resource(GetArticle, '/article', endpoint='get_article')

if __name__ == '__main__':
    app.run(debug=True)