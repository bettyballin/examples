
from google.cloud import securitycenter_v1

client = securitycenter_v1.SecurityCenterClient.from_service_account_json('path_to_service_account.json')

# organization_id should be a string in the form of 'organizations/{org_id}'
organization_id = 'organizations/1234567890'
# source_id should be a string in
