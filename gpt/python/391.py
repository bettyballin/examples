
from google.cloud import securitycenter
from google.cloud import bigquery

# Path to Service Account Key JSON file
JSONPath = "Path to JSON File For Service Account"

# Initialize Security Command Center and BigQuery clients
client = securitycenter.SecurityCenterClient.from_service_account_json(JSONPath)
BQclient = bigquery.Client.from_service_account_json(JSONPath)

# BigQuery table ID
table_id = "your-project.your_dataset.your_table"

# Organization name for the Security Command Center
org_name = "organizations/1234567891011"
all_sources = "{org_name}/sources/-".format(org_name=org_name)

# List findings
finding_result_iterator = client.list_findings
