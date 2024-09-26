from flask import current_app, after_this_request

def flask_security_datastore_commit(response=None):
    datastore = current_app.extensions['security'].datastore
    datastore.commit()
    return response