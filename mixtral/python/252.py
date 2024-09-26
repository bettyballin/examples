import os
from oauthlib.oauth1 import OAuth

CLIENT_KEY = os.environ['YOUR_ENVIRONMENT_VARIABLE']
CLIENT_SECRET = os.environ['OTHER_ENVIRONMENT_VARIABLE']
RESOURCE_OWNER_KEY = os.environ['ANOTHER_ONE']
RESOURCE_OWNER_SECRET = os.environ['LAST_EXAMPLE']

oauth = OAuth(
    CLIENT_KEY,
    client_secret=CLIENT_SECRET,
    resource_owner_key=RESOURCE_OWNER_KEY,
    resource_owner_secret=RESOURCE_OWNER_SECRET
)