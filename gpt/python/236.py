
   import os
   import json
   from google.oauth2 import service_account
   from google.cloud import firestore

   service_account_info = json.loads(os.environ['SERVICE_ACCOUNT_JSON'])
   credentials = service_account.Credentials
