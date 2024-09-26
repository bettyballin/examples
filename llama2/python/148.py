from google.cloud import securitycenter
from google.auth.transport.requests import Request
from google.oauth2 import service_account

# Set up service account credentials
creds = None
if creds is None or not creds.valid:
    if creds and creds.expired and creds.refresh_token:
        creds.refresh(Request())
    else:
        creds = service_account.Credentials.from_service_account_file(
            'path/to/credentials.json',
            scopes=['https://www.googleapis.com/auth/cloud-platform']
        )

# Create the SecurityCenterClient with the credentials
client = securitycenter.SecurityCenterClient(credentials=creds)

# Set the organization ID
org_id = 'your-organization-id'

# Set the source query
all_sources = securitycenter.ListFindingsRequest(
    parent=f'organizations/{org_id}/sources/-',
    filter_='severity="HIGH"'
)

# Call the list_findings() method
finding_result_iterator = client.list_findings(request=all_sources)

# Print the findings
for i, finding_result in enumerate(finding_result_iterator):
    print(f'Finding {i}: {finding_result.finding.name}')