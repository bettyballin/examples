import boto3

ec2 = boto3.client('ec2')

# Describe the security groups
response = ec2.describe_security_groups(
    GroupIds=['sg-11111', 'sg-22222']
)

# Check if the security group exists
for sg in response['SecurityGroups']:
    if sg['GroupId'] == 'sg-11111':
        print('Security group sg-11111 exists')
        break
else:
    print('Security group sg-11111 does not exist')

# Revoke ingress for a specific security group
try:
    response = ec2.revoke_security_group_ingress(
        GroupId='sg-11111',
        IpPermissions=[
            {
                'IpProtocol': 'tcp',
                'FromPort': 80,
                'ToPort': 80,
                'UserIdGroupPairs': [
                    {
                        'GroupId': 'sg-22222'
                    }
                ]
            }
        ]
    )
    print('Ingress revoked successfully')
except Exception as e:
    print('Error revoking ingress:', str(e))