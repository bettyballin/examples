import requests

IBMCLOUD_TOKEN = "YOUR_TOKEN_HERE"

headers = {
    "Authorization": IBMCLOUD_TOKEN,
    "Content-Type": "application/json"
}

response = requests.get("https://accounts.cloud.ibm.com/v1/accounts", headers=headers)

print(response.text)