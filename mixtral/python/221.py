from ibm_botocore.client import Config
import boto3

cos = boto3.resource('s3',
    endpoint_url='https://control.cloud-object-storage.cloud.ibm.com/v2/endpoints',
    aws_access_key_id="dfe869efasdasd",
    aws_secret_access_key="f04e500a66asdasdasd5bfd34c82",
    config=Config(signature_version='oauth'))

bucket = cos.Bucket('my-test-bucket')

# Generate a presigned URL for uploading files
url = bucket.meta.client.generate_presigned_url(
    ClientMethod='put_object',
    Params={'Bucket': 'my-test-bucket',
            'Key': 'uploaded/file.txt'},
    ExpiresIn=3600)

print("Presigned URL for uploading files:", url)