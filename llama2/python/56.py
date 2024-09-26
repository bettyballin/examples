import os

# Set environment variables
os.environ['DJANGO_EMAIL_PASSWORD'] = 'your_email_password'
os.environ['DJANGO_S3_BUCKET_NAME'] = 'your_bucket_name'
os.environ['DJANGO_S3_ACCESS_KEY'] = 'your_access_key'
os.environ['DJANGO_S3_SECRET_KEY'] = 'your_secret_key'

# Load environment variables
EMAIL_PASSWORD = os.environ['DJANGO_EMAIL_PASSWORD']
S3_BUCKET_NAME = os.environ['DJANGO_S3_BUCKET_NAME']
S3_ACCESS_KEY = os.environ['DJANGO_S3_ACCESS_KEY']
S3_SECRET_KEY = os.environ['DJANGO_S3_SECRET_KEY']