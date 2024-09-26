import os
import firebase_admin
from firebase_admin import credentials, db

cred = credentials.Certificate('path/to/your-serviceAccountKey.json')
firebase_app = firebase_admin.initialize_app(cred, {
    'databaseURL': 'https://your-database-url.firebaseio.com'
})

# Get a reference to the database service
ref = db.reference('/people')