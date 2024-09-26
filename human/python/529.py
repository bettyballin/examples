import boto3

ec2 = boto3.client('ec2')

instance = ec2.create_security_group(
    GroupName='MyWebServer',
    Description='WebServer',
    VpcId='vpc-0dea879f34afff60d'
)

print(instance)