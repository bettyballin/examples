from azure.mgmt.security import SecurityCenter
from azure.identity import ClientSecretCredential
import requests

TENANT_ID = 'your_tenant_id'
CLIENT = 'your_client_id'
KEY = 'your_client_secret'
subscription_id = 'your_subscription_id'

getLocationsURL = f"https://management.azure.com/subscriptions/{subscription_id}/providers/Microsoft.Security/locations?api-version=2015-06-01-preview"

credentials = ClientSecretCredential(
    client_id=CLIENT,
    client_secret=KEY,
    tenant_id=TENANT_ID
)

# request for asc_location for a subscription
azure_access_token = credentials.get_token('https://management.azure.com/.default')
r = requests.get(getLocationsURL, headers={"Authorization": f"Bearer {azure_access_token.token}"}).json()
location = r['value'][0]['name']
print(f"location: {location}")

client = SecurityCenter(credentials, subscription_id, asc_location=location)
for score in client.secure_scores.list():
    print(score)