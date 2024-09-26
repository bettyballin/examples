import AzureIdentity
from azure.identity import DefaultAzureCredential
from azure.mgmt.core import CoreClient
from azure.mgmt.core.models import Client

# Initialize the Azure credential
credential = DefaultAzureCredential()

# Initialize the Azure client
client = CoreClient(credential)

asc_location = client.get_subscription_info()['ascLocation']
print(asc_location)