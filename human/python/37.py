import boto
from boto.s3.connection import S3Connection

AWS_ACCESS_KEY_ID = 'YOUR_ACCESS_KEY_ID'
AWS_SECRET_ACCESS_KEY = 'YOUR_SECRET_ACCESS_KEY'
bucket_name = 'YOUR_BUCKET_NAME'
file_name = 'YOUR_FILE_NAME'

conn = S3Connection(AWS_ACCESS_KEY_ID,
                    AWS_SECRET_ACCESS_KEY, is_secure=False)

# The generated temp_url remains valid for 60 seconds in this case
temp_url = conn.generate_url(60, 'GET', bucket=bucket_name, 
                             key=file_name, force_http=True)

print(temp_url)