from google.cloud import securitycenter
from google.cloud import bigquery

JSONPath = "Path to JSON File For Service Account"
client = securitycenter.SecurityCenterClient.from_service_account_json(JSONPath)
BQclient = bigquery.Client.from_service_account_json(JSONPath)
table_id = "project.security_center.assets"
org_name = "organizations/1234567891011"
all_sources = "{}/sources/-".format(org_name)
finding_result_iterator = client.list_findings(request={"parent": all_sources})

rows_to_insert = []
for finding in finding_result_iterator:
    rows_to_insert.append({
        "field1": finding["field1"],
        # Add more fields as needed
    })

errors = BQclient.insert_rows_json(table_id, rows_to_insert)
if not errors:
     print("New rows have been added.")
else:
     print("Encountered errors while inserting rows: {}".format(errors))