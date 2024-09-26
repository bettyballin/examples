import os
import json
from google.oauth2 import service_account
from google.cloud import securitycenter

# Replace with your service account key file
SERVICE_ACCOUNT_KEY_FILE = "gcp-sc.json"

# Load credentials from service account key file
creds = service_account.Credentials.from_service_account_file(
    SERVICE_ACCOUNT_KEY_FILE,
    scopes=["https://www.googleapis.com/auth/cloud-platform"]
)

# Create Security Center client
client = securitycenter.SecurityCenterClient(credentials=creds)