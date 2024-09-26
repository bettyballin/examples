import json
from botocore.client import Config
import ibm_boto3

# Initialize the COS client
cos = ibm_boto3.client('s3',
    aws_access_key_id='YOUR_API_KEY',
    aws_secret_access_key='YOUR_SECRET_ACCESS_KEY',
    config=Config(signature_version='s3v4'),
    endpoint_url='https://s3.us.cloud-object-storage.appdomain.cloud'
)

# Define the presigned URL parameters
expires = 3600 # 1 hour
bucket_name = 'my-bucket'
key = 'upload/path/to/file.txt'

# Generate the presigned URL
presigned_url = cos.generate_presigned_url(
    'put_object',
    Params={'Bucket': bucket_name, 'Key': key},
    ExpiresIn=expires
)

print(presigned_url)