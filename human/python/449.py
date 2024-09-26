from google.cloud import securitycenter

if __name__ == "__main__":
    SecurityCenterClient = securitycenter.SecurityCenterClient
    client = SecurityCenterClient.from_service_account_json('gcp-sc.json')