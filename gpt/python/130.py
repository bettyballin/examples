
# Set up Firebase Admin
import firebase_admin
from firebase_admin import credentials, auth

cred = credentials.Certificate('path/to/serviceAccountKey.json')
firebase_admin.initialize_app(cred)

# Set custom claims
auth.set_custom_user_claims('supervisor_user_id', {'supervisorName': 'Mike P.'})

