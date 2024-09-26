import boto3

ec2 = boto3.client('ec2')

GroupId = 'sg-ZZ'  # Source Security Group ID
FromPort = 80  # replace with your from port
ToPort = 80  # replace with your to port
Protocol = 'tcp'  # replace with your protocol
UserIdGroupPairsGroupId = 'sg-yy'  # replace with your user id group pairs group id

response = ec2.revoke_security_group_ingress(
    GroupId=GroupId,
    IpPermissions=[
        {
            'IpProtocol': Protocol,
            'FromPort': FromPort,
            'ToPort': ToPort,
            'UserIdGroupPairs': [
                {'GroupId': UserIdGroupPairsGroupId}
            ]
        }
    ]
)

print(response)