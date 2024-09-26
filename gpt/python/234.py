
   from flask import request, jsonify, abort
   from flask_security import anonymous_user_required

   @anonymous_user_required
   @app.route('/api/login', methods=['POST'])
   def api_login():
       # Your existing code with the form handling removed.
   
