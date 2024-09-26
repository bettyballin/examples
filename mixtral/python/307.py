import json
from google.cloud import securitycenter

def get_security_center_client(json_keyfile):
    return securitycenter.SecurityCenterClient.from_service_account_info({
        "type": "service_account",
        "project_id": json_keyfile["project_id"],
        "private_key_id": json_keyfile["private_key_id"],
        "private_key": json_keyfile["private_key"],
        "client_email": json_keyfile["client_email"],
        "token_uri": "https://oauth2.googleapis.com/token",
    })

json_credentials = "<path-to-your-serviceaccount>.json"
with open(json_credentials) as f:
    json_keyfile = json.load(f)

client = get_security_center_client(json_keyfile)