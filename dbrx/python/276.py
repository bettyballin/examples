import boto3

ec2 = boto3.resource('ec2')
client = boto3.client('ec2')

# Create a new Security Group
security_group  = ec2.create_security_group(
    GroupName='MyWebServer',
    Description='WebServer',
    VpcId='vpc-0dea879f34afff60d'
)

instance_id = 'i-your-instance-id'

# Get the instance object by ID
instance = ec2.Instance(instance_id)

# Modify the security group of an existing EC2 Instance
response = client.modify_instance_attribute(
    InstanceId=instance.id,
    Groups=[security_group.group_id]
)

print(response)