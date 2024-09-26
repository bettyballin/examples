import os
from google.cloud import securitycenter
from google.oauth2 import service_account

# Set environment variable
os.environ["GOOGLE_CLOUD_PROJECT"] = "your-organization-id"

credentials = service_account.Credentials.from_service_account_file('svc-scc.json')

client = securitycenter.SecurityCenterClient(credentials=credentials)

# organization_id is the numeric ID of the organization
org_name = "organizations/{}".format("your-organization-id")

all_sources = "{}/sources/-".format(org_name)
finding_result_iterator = client.list_findings(all_sources)

for i, finding_result in enumerate(finding_result_iterator):
    print("{}: name: {} resource: {}".format(i, finding_result.finding.name, finding_result.finding.resource_name))