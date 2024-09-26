import os
from azure.securitycenter import ASCClient

# Replace with your subscription ID
subscription_id = 'your-subscription-id'

# Replace with your resource group name
resource_group_name = 'your-resource-group-name'

# Replace with your workspace name
workspace_name = 'your-workspace-name'

# Create a client instance
asc_client = ASCClient(subscription_id, os.environ.get("AZURE_AUTH_LOCATION"))

alerts_list = asc_client.alerts.list_by_resource_group(
    resource_group_name=resource_group_name,
    workspace_name=workspace_name
)

for alert in alerts_list:
    print(f'Alert ID: {alert.name}')