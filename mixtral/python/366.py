import boto3

ec2 = boto3.resource('ec2')

# Create a new EC2 instance
instance = ec2.create_instances(
    ImageId='ami-0fc970315c2d38f01',
    MinCount=1,
    MaxCount=1,
    InstanceType='t2.nano'
)[0]

print("Instance ID: ", instance.id)

# Create a new security group
security_group = ec2.create_security_group(
    GroupName='MyWebServer',
    Description='Web Server Security Group',
    VpcId='vpc-0dea879f34afff60d'
)

print("Security Group ID: ", security_group.id)

# Add the new EC2 instance to the newly created security group
instance.modify_attribute(Groups=[security_group.id])