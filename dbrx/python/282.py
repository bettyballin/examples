from google.cloud import securitycenter
from google.cloud import bigquery

JSONPath = "Path to JSON File For Service Account"
client = securitycenter.SecurityCenterClient.from_service_account_json(JSONPath)
BQclient = bigquery.Client.from_service_account_json(JSONPath)

table_id = "project.security_center.assets"
org_name = "organizations/1234567891011"

all_sources = "{org_name}/sources/-".format(org_name=org_name)

finding_results_list = []

for i, finding_result in enumerate(client.list_findings(request={"parent": all_sources})):
    # Convert FindingResult object to a dictionary
    findings_dict = {
        "name": finding_result.finding.name,
        "resourceName": finding_result.resource.display_name,
        "state": finding_result.state,
        # Add other fields you want to include in the BigQuery table here...
    }
    
    finding_results_list.append(findings_dict)

# Insert rows into BQ
errors = BQclient.insert_rows_json(table_id, finding_results_list)
if errors == []:
    print("New rows have been added.")
else:
    print(f"Encountered errors while inserting rows: {errors}")