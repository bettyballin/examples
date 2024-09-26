
from flask import jsonify
from flask_security import auth_token_required, current_user

@app.route('/protected')
@auth_token_required
def protected():
    # Access the user's ID using current_user
    user_id = current_user.get_id()

    # Now you can use the user_id to perform actions specific to the user
    # For example, fetching user-specific data from the database

    return jsonify({'message': f'Accessed by user with ID: {user_id}'})

