import os
from oauthlib.oauth1 import OAuth

CLIENT_KEY = open(os.path.expanduser('~/.secrets/client-key')).read().strip()
CLIENT_SECRET = open(os.path.expanduser('~/.secrets/client-secret')).read().strip()
RESOURCE_OWNER_KEY = open(os.path.expanduser('~/.secrets/access-token-key')).read().strip()
RESOURCE_OWNER_SECRET = open(os.path.expanduser('~/.secrets/access-token-secret')).read().strip()

oauth = OAuth(
    client_key=CLIENT_KEY,
    client_secret=CLIENT_SECRET,
    resource_owner_key=RESOURCE_OWNER_KEY,
    resource_owner_secret=RESOURCE_OWNER_SECRET
)