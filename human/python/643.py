import json

def extractAccount(iam_token):
    # assuming iam_token is a JSON string
    token_data = json.loads(iam_token)
    return token_data

iam_token = '{"account": {"bss": "12345"}}'  # replace with your actual token
token_data = extractAccount(iam_token)
account_id = token_data["account"]["bss"]
print(account_id)