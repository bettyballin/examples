
from google.oauth2 import service_account
from google.auth.transport.requests import Request
import requests

# Path to your service account key file
SERVICE_ACCOUNT_FILE = 'path/to/service-account-file.json'

# Define the scope for Google Cloud Storage
SCOPES = ['https://www.googleapis.com/auth/devstorage.read_write']

# Create a credentials object
credentials = service_account.Credentials.from_service_account_file(
        SERVICE_ACCOUNT_FILE, scopes=SCOPES)

# Use the credentials object to authenticate and obtain an access token
credentials.refresh(Request())

# Now you have a valid access token
access
