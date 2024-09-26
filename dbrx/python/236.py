import boto3

ec2_client = boto3.client('ec2')

response = ec2_client.revoke_security_group_ingress(
    GroupId='sg-yy',
    IpPermissions=[
        {
            'IpProtocol': '-1',  # all protocols
            'UserIdGroupPairs': [
                {
                    'GroupId': 'sg-ZZ'
                }
            ]
        }
    ]
)