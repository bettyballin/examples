import boto3

cos = boto3.client('s3')
mybucket = 'your-bucket-name'
myobject = 'your-object-key'

theURL=cos.generate_presigned_url('get_object', Params = {'Bucket': mybucket, 'Key': myobject}, ExpiresIn = 600)

print(theURL)