
from azure.identity import DefaultAzureCredential
from azure.mgmt.security import SecurityCenter

# Authenticate with Azure
credentials = DefaultAzureCredential()
subscription_id = 'your-subscription-id'

# Initialize the SecurityCenter client
security_client = SecurityCenter(credentials, subscription_id)

# List the security alerts
for alert in security_client.alerts.list():
    print(alert)

