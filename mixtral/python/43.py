from google.oauth2 import service_account
import requests

def postTest():
    # Load JSON key file
    creds = service_account.Credentials.from_service_account_file('YOUR_JSON_KEYFILE')

    headers = {
        'Host': 'www.googleapis.com',
        'Content-Length': '0',
        'Content-Type': 'text/plain'
    }

    # Set access token in Authorization header
    creds.refresh(requests.Request())
    headers['Authorization'] = f'Bearer {creds.token}'

    files = {'file': ('report.txt', 'justsomeblankityblanktext')}

    r = requests.post(
        "https://storage.googleapis.com/upload/storage/v1beta2/b/NOTACTUALLYAREALBUCKETOBVIOUSLY/o?uploadType=media&name=testi.txt",
        headers=headers,
        files=files
    )

    print(r.request.headers)
    print(r.url)
    print(r.text)

postTest()