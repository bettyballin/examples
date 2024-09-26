import json
import base64

# use split and base64 to get to the content of the IAM token
def extractAccount(iam_token):
    data = iam_token.split('.')
    padded = data[1] + "=" * divmod(len(data[1]), 4)[1]
    jsondata = json.loads(base64.urlsafe_b64decode(padded))
    return jsondata