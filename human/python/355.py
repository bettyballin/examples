import requests

d = {
    "client_id": "<client_id>",
    "scope": ["https://graph.microsoft.com/.default"],
    "client_secret": "<client_secret>",
    "grant_type": "client_credentials"
}
r = requests.post("https://login.microsoftonline.com/{tenant}/oauth2/v2.0/token".format(tenant="<tenant>"), data=d)