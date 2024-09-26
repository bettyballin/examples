from azure.mgmt.security import SecurityCenter
from azure.common.credentials import ServicePrincipalCredentials

subscription_id = "xxxx"

# Tenant ID for your Azure subscription
TENANT_ID = '<Your tenant ID>'

# Your service principal App ID
CLIENT = '<Your service principal ID>'

# Your service principal password
KEY = '<Your service principal password>'

credentials = ServicePrincipalCredentials(
    client_id = CLIENT,
    secret = KEY,
    tenant = TENANT_ID
)

client = SecurityCenter(credentials=credentials, subscription_id=subscription_id, asc_location="centralus")

try:
    alerts_list = client.alerts.list()
    for alert in alerts_list:
        print(alert)
except Exception as e:
    print(f"An error occurred: {e}")