
    import os
    from requests_ntlm import HttpNtlmAuth
    import requests

    username = os.getenv('SERVICE_ACCOUNT_USERNAME')
    password = os.getenv('SERVICE_ACCOUNT_PASSWORD')
    auth = HttpNtlmAuth(username, password)

    content = requests.post(call_string, json=parameters, auth=auth)
    
