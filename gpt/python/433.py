
import jwt
from datetime import datetime, timedelta

# Your service ID and RSA private key
service_id = "abc"
private_key = """
-----BEGIN RSA PRIVATE KEY-----
# Your RSA Key Here
-----END RSA PRIVATE KEY-----
"""

# IAM URL and audience endpoint
iam_url = "https://your.iam.url"  # Replace with your IAM URL
audience_endpoint = "/oauth2/access_token"  # Replace with your audience endpoint

# Calculate the expiration time
expiration_time = datetime.now() + timedelta(minutes=10)

# Define the payload
payload = {
    "iss": service_id,
    "sub": service_id,
    "exp": int(expiration_time.timestamp()),
    "aud": iam_url
