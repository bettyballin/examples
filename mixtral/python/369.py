from google.cloud import secretmanager

def get_secret(project_id, secret_name):
    client = secretmanager.SecretManagerServiceClient()

    name = f"projects/{project_id}/secrets/{secret_name}/versions/latest"

    response = client.access_secret_version(request={
        "name": name
    })

    return response.payload.data.decode('UTF-8')

# Usage
credentials_json = get_secret("your-gcp-project", "google-application-credentials")
print(credentials_json)