import boto3
import logging

def generate_presigned_url(client, bucket_name, object_name, expiration=3600):
    """Generate a presigned URL to share an S3 object

    :param client: The Boto3 S3 client.
    :param bucket_name: str. Name of the target Bucket.
    :param object_name: str. Key name for which we want generate pre-signed url
    :param expiration: Time in seconds until link expires (default is 3600)
    """
    try:
        response = client.generate_presigned_url(
            'get_object',
            Params={
                'Bucket': bucket_name,
                'Key': object_name
            },
            ExpiresIn=expiration
        )
    except client.exceptions.ClientError as e:
        logging.error(e)
        return None

    # The presigned URL can be shared with others.
    print(f'Presigned URL: {response}')
    return response

# Example usage
s3_client = boto3.client('s3')
bucket_name = 'your-bucket-name'
object_name = 'your-object-name'

generate_presigned_url(s3_client, bucket_name, object_name)