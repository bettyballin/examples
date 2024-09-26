
import boto3
from datetime import datetime, timedelta

# Initialize a session using your AWS credentials
s3_client = boto3.client('s3', aws_access_key_id='YOUR_ACCESS_KEY', aws_secret_access_key='YOUR_SECRET_KEY', region_name='YOUR_REGION')

# The name of your S3 bucket and object
bucket_name = 'your-bucket-name'
object_key = 'path/to/your/financial/statement
