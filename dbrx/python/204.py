from azure.identity import ClientSecretCredential

CLIENT_ID = 'your-client-id'
SECRET = 'your-client-secret'
TENANT_ID = 'your-tenant-id'

credentials = ClientSecretCredential(
    client_id=CLIENT_ID,
    client_secret=SECRET,
    tenant_id=TENANT_ID
)

subscription_id = 'your-subscription-id'