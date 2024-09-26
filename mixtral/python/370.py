import json
from google.oauth2 import service_account

def decode_and_authenticate(encoded_json):
    decoded = encoded_json.decode("utf-8")

    creds = service_account.Credentials.from_service_account_info(
        json.loads(decoded)
    )

    return creds

# Usage
def get_secret(project_id, secret_id):
    from google.cloud import secretmanager
    client = secretmanager.SecretManagerServiceClient()
    secret_name = f"projects/{project_id}/secrets/{secret_id}/versions/latest"
    response = client.access_secret_version(name=secret_name)
    return response.payload.data

credentials = decode_and_authenticate(get_secret("your-gcp-project", "google-application-credentials"))