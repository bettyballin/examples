import ibm_boto3
import json

# Load configuration from JSON file
with open('config.json') as f:
    config = json.load(f)

# Define variables
myserviceapikey = config["service_api_key"]
myendpointurl = config["endpoint_url"]

# Create COS client
cos = ibm_boto3.client('s3', 
                      api_key_id=myserviceapikey, 
                      endpoint_url=myendpointurl, 
                      aws_access_key_id=config["cos_hmac_keys"]["access_key_id"], 
                      aws_secret_access_key=config["cos_hmac_keys"]["secret_access_key"])