import datetime as dt
from azure.identity import DefaultAzureCredential
from azure.storage.blob import (
    BlobClient,
    BlobServiceClient,
    generate_user_delegation_key
)

credential = DefaultAzureCredential(exclude_shared_token_cache_credential=True)

# Replace these with your storage account and blob details
STORAGE_ACCOUNT_NAME = "XYZ_storage_account"
CONTAINER_NAME = "XYZ_blob_container"
BLOB_NAME = "xyz_data.json"

url = f'https://{STORAGE_ACCOUNT_NAME}.blob.core.windows.net/'

# Create a BlobServiceClient object
service_client = BlobServiceClient(
    url,
    credential=credential
)

try:
    # Generate User Delegation Key
    udk = generate_user_delegation_key(
        service_client,
        dt.timedelta(days=1)
    )
    print("User Delegation Key generated successfully:", udk)

    # Create a BlobClient object
    blob_client = service_client.get_blob_client(CONTAINER_NAME, BLOB_NAME)

    # Use the BlobClient to perform operations on the blob
    blob_data = blob_client.download_blob().content_as_text()
    print("Blob data:", blob_data)

except Exception as e:
    print("Error:", e)