import google.auth
from google.cloud import firestore

# Load private key as dict (e.g by reading it from Datastore)
private_key_dict = {
    "type": "service_account",
    "project_id": "your-project-id",
    "private_key_id": "your-private-key-id",
    "private_key": "your-private-key",
    "client_email": "your-client-email",
    "client_id": "your-client-id",
    "auth_uri": "https://accounts.google.com/o/oauth2/auth",
    "token_uri": "https://oauth2.googleapis.com/token",
    "auth_provider_x509_cert_url": "https://www.googleapis.com/oauth2/v1/certs",
    "client_x509_cert_url": "https://www.googleapis.com/robot/v1/metadata/x509/your-service-account-email"
}

credentials = google.oauth2.service_account.Credentials.from_service_account_info(private_key_dict)

db = firestore.Client(credentials=credentials, project="your-project-id")