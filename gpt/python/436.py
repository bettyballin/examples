
from azure.identity import DefaultAzureCredential
from azure.mgmt.security import SecurityCenter
from pprint import pprint

# Create a DefaultAzureCredential, which will handle the authentication for us
credentials = DefaultAzureCredential()

# You need to provide your subscription_id
subscription_id = "your-subscription-id"

# Instantiate the SecurityCenter client with the new credentials
client = SecurityCenter
