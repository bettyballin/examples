from flask import request, jsonify
from flask_restful import Resource, reqparse

@article_manager.route('/')
class GetArticle(Resource):
    @auth_token_required("token")
    def get(self):
        parser = reqparse.RequestParser()
        parser.add_argument('title', type=str, location='args')
        parser.add_argument('id', type=int, location='args')
        args = parser.parse_args()
        title = args.get('title')
        id = args.get('id')
        with app.app_context():
            # Your code here...
            pass