
import ibm_boto3
from ibm_botocore.client import Config
import ibm_s3transfer as S3Transfer

# Initialize a session using IBM COS credentials
cos_credentials = {
    "cos_hmac_keys": {
        "access_key_id": "dfe869efasdasd",
        "secret_access_key": "f04e500a66asdasdasd5bfd34c82"
    }
}

# Create a COS client using the ibm_boto3 library
cos_client = ibm_boto3.client('s3',
                              aws_access_key_id=cos_credentials['cos_hmac_keys']['access_key_id'],
                              aws_secret_access_key=cos_credentials['cos_hmac_keys
