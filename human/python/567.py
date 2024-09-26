from flask import Flask
from flask_restful import Api, Resource, reqparse
from flask_httpauth import HTTPTokenAuth

app = Flask(__name__)
api = Api(app)
auth = HTTPTokenAuth(scheme='Bearer')

article_manager = api.namespace('article_manager', description='Article Manager')

@article_manager.route('/<string:title>', '/<int:id>')
class GetArticle(Resource):

    @auth_token_required
    def get(self, title=None, id=None):
        pass

if __name__ == '__main__':
    app.run(debug=True)