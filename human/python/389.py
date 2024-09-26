!pip install google-cloud-secret-manager
from google.cloud import secretmanager

# Create a Client:
client = secretmanager.SecretManagerServiceClient()
secret_name = "my-secret"  # => To be replaced with your secret name
project_id = 'my-project'  # => To be replaced with your GCP Project

# Forge the path to the latest version of your secret with an F-string:
resource_name = f"projects/{project_id}/secrets/{secret_name}/versions/latest"

# Get your secret :
response = client.access_secret_version(request={"name": resource_name})
secret_string = response.payload.data.decode('UTF-8')

# Tada ! your secret is in the secret_string variable!
print(secret_string)