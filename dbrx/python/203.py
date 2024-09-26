import os
from azure.mgmt.security import SecurityCenter
from msrestazure.azure_active_directory import ServicePrincipalCredentials

# Replace with your Azure credentials
AZURE_TENANT_ID = os.environ.get("AZURE_TENANT_ID")
AZURE_CLIENT_ID = os.environ.get("AZURE_CLIENT_ID")
AZURE_CLIENT_SECRET = os.environ.get("AZURE_CLIENT_SECRET")
AZURE_SUBSCRIPTION_ID = os.environ.get("AZURE_SUBSCRIPTION_ID")

credentials = ServicePrincipalCredentials(
    client_id=AZURE_CLIENT_ID,
    secret=AZURE_CLIENT_SECRET,
    tenant=AZURE_TENANT_ID
)

security_center = SecurityCenter(credentials, AZURE_SUBSCRIPTION_ID)

# Use the security_center object to call Security Center APIs