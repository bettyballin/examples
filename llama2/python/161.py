from google.cloud import securitycenter
from google.cloud import bigquery

def main():
    JSONPath = "Path to JSON File For Service Account"
    client = securitycenter.SecurityCenterClient.from_service_account_json(JSONPath)
    BQclient = bigquery.Client.from_service_account_json(JSONPath)
    table_id = "project.security_center.assets"
    org_name = "organizations/1234567891011"
    all_sources = ",".join([f"{org_name}/{source}" for source in ["*"]]) # API wants a comma-separated list of source paths, not dots
    finding_results = list(client.list_findings(all_sources))

    errors = BQclient.insert_rows_json(table_id, [{"finding": finding.to_dict()} for finding in finding_results])
    if not errors:
        print("New rows have been added.")
    else:
        print("Encountered errors while inserting rows: {}".format(errors))

if __name__ == "__main__":
    main()