from google.cloud import securitycenter
from google.oauth2 import service_account
import os

credentials = service_account.Credentials.from_service_account_file('svc-scc.json')

# Set the default project to your organization ID
os.environ["GOOGLE_CLOUD_PROJECT"] = "your-organization-id"

client = securitycenter.SecurityCenterClient(credentials=credentials)

org_name = "organizations/{}".format("your-organization-id")

all_sources = "{}/sources/-".format(org_name)
finding_result_iterator = client.list_findings(all_sources)

for i, finding_result in enumerate(finding_result_iterator):
    print(finding_result)