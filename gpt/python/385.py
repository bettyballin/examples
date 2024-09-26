
import boto3

ec2 = boto3.resource('ec2')

# Create a security group
sec_group = ec2.create_security_group(
    GroupName='MyWebServer',
    Description='WebServer',
    VpcId='vpc-0dea879f34afff60d'
)

# Authorize access to the security group (example: allow HTTP)
sec_group.authorize_ingress(
    CidrIp='0.0.0.0/0',
    IpProtocol='tcp',
    FromPort=80,
    ToPort=80
)

# Create an instance with the new security group
instances = ec2.create_instances(
    ImageId='ami-0fc970315c2
