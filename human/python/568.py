from flask import Flask
from flask_restful import Api, Resource, reqparse
from flask_jwt_extended import jwt_required, get_jwt_identity

app = Flask(__name__)
app.config['JWT_SECRET_KEY'] = 'super-secret'  # Change this!
api = Api(app)

article_manager = api.namespace('article', description='Article operations')

@article_manager.route('/<string:title>', '/<int:id>')
class GetArticle(Resource):

    @jwt_required
    def get(self, title=None, id=None):
        pass

if __name__ == '__main__':
    app.run(debug=True)