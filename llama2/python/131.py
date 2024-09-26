import os

from azure.mgmt.security import SecurityCenter
from azure.common.credentials import ServicePrincipalCredentials

# Define Azure credentials
AZURE_TENANT_ID = os.environ.get('AZURE_TENANT_ID')
AZURE_CLIENT_ID = os.environ.get('AZURE_CLIENT_ID')
AZURE_CLIENT_SECRET = os.environ.get('AZURE_CLIENT_SECRET')
AZURE_SUBSCRIPTION_ID = os.environ.get('AZURE_SUBSCRIPTION_ID')

# Create credentials
credentials = ServicePrincipalCredentials(
    client_id=AZURE_CLIENT_ID,
    secret=AZURE_CLIENT_SECRET,
    tenant=AZURE_TENANT_ID
)

# Create Security Center client
security_center = SecurityCenter(credentials, AZURE_SUBSCRIPTION_ID)

# Use the Security Center client to perform operations
# For example, get the list of security alerts
alerts = security_center.alerts.list()
for alert in alerts:
    print(alert.name)