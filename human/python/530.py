import boto3

ec2 = boto3.client('ec2')

sg = ec2.create_security_group(
    GroupName='MyWebServer',
    Description='WebServer',
    VpcId='vpc-0dea879f34afff60d'
)

instance = ec2.run_instances(
    ImageId='ami-0fc970315c2d38f01',
    MinCount=1,
    MaxCount=1,
    InstanceType='t2.nano',
    SecurityGroupIds=[sg['GroupId']]
)