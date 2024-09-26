from google.cloud import storage
from google.oauth2 import service_account

credentials = service_account.Credentials.from_service_account_file(
    'path_to_your_service_account_key.json'
)

def list_buckets():
    client = storage.Client(
        project=credentials.project_id,
        credentials=credentials
    )

    return [bucket.name for bucket in client.list_buckets()]

# Usage
print(list_buckets())