from google.cloud import secretmanager_v1beta1 as smv1b1

def access_secret_version(project_id, secret_id, version_id):
    # Create a client for accessing secrets.
    client = smv1b1.SecretManagerServiceClient()

# Example usage:
# access_secret_version('my-project', 'my-secret', 'latest')