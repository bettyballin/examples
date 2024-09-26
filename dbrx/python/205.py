from azure.securitycenter import SecurityCenter

# Define your credentials and subscription ID
credentials = {
    'tenant_id': 'your_tenant_id',
    'client_id': 'your_client_id',
    'client_secret': 'your_client_secret'
}
subscription_id = 'your_subscription_id'

# Create a Security Center client
asc_client = SecurityCenter(
    credential=credentials,
    subscription_id=subscription_id
)