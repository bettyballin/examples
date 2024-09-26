import boto3
from botocore.client import Config

def generate_presigned_url(client, bucket_name, object_name):
    return client.generate_presigned_url(
        'get_object',
        Params={'Bucket': bucket_name, 'Key': object_name},
        ExpiresIn=3600  # expires in 1 hour
    )

s3 = boto3.client('s3', config=Config(signature_version='s3v4'))

bucket_name = 'my-bucket'
object_name = 'path/to/my/object.txt'

url = generate_presigned_url(s3, bucket_name, object_name)
print(f'Presigned URL: {url}')