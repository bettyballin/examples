import bcrypt

def store_user(username, password):
    # Generate unique salt per-user.
    user_salt = bcrypt.gensalt()
    
    # Hash the plaintext password using generated salt and BCrypt library.
    hashed_password = bcrypt.hashpw(password.encode('utf-8'), user_salt)

    # Store both fields in Firebase DB under same document/collection for each user.
    # NOTE: You need to install and import the firebase-admin library for this to work
    import firebase_admin
    from firebase_admin import credentials, firestore

    # Initialize Firebase app
    cred = credentials.Certificate("path/to/serviceAccountKey.json")
    firebase_admin.initialize_app(cred)
    db = firestore.client()

    # Store user data in Firestore
    user_ref = db.collection('users').document(username)
    user_ref.set({
        'username': username,
        'hashed_password': hashed_password.decode('utf-8')
    })

# Example usage:
store_user('john_doe', 'mysecretpassword')