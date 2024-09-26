from azure.securitycenter import SecurityCenter
from azure.identity import DefaultAzureCredential

# Initialize credentials
credential = DefaultAzureCredential()

# Set subscription ID
subscription_id = "your_subscription_id"

# Create a SecurityCenter client
client = SecurityCenter(credential, subscription_id)

# Get the subscription information
subscription_info = client.get_subscription_info()

# Extract the ASC location from the subscription information
asc_location = subscription_info.get('ascLocation')

print(asc_location)