from azure.common.credentials import ServicePrincipalCredentials
from azure.mgmt.security import SecurityCenter

# Authentication
subscription_id = '<your-subscription-ID>'
tenant_id       = '<your-tenant-ID>'
client_id       = '<your-application/service-principle-appId>'
secret          = '<your-authentication-key>'

credentials     = ServicePrincipalCredentials(
    client_id=client_id,
    secret=secret,
    tenant=tenant_id
)

# Create a security center management client
securitycenter_client = SecurityCenter(credentials, subscription_id)