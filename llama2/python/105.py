import os
from requests_ntlm import HttpNtlmAuth

os.environ["SERVICE_ACCOUNT_PASSWORD"] = "my_secret_password"

class Config:
    ServiceAccount = {
        "Username": "your_service_account_username"
    }

config = Config()

auth = HttpNtlmAuth(
    config.ServiceAccount["Username"],
    os.environ["SERVICE_ACCOUNT_PASSWORD"]
)