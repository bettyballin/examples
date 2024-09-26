import os
import boto3
from botocore.client import Config, ClientError

# Set variables for COS instance.
service_endpoint = 'https://s3.us.cloud-object-storage.appdomain.cloud'
access_key_id = '<your_access_key>'
secret_access_key = '<your_secret_access_key>'

config = Config(signature_version='s3v4', service_name='s3')

client = boto3.client(
    's3',
    endpoint_url=service_endpoint,
    aws_access_key_id=access_key_id,
    aws_secret_access_key=secret_access_key,
    config=config
)