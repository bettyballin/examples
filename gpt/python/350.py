
import boto3

# Create an EC2 resource instance
ec2 = boto3.resource('ec2')

# Replace 'sg-ZZ' with the ID of the security group you're modifying
security_group_id_to_modify = 'sg-ZZ'

# Replace 'sg-yy' with the ID of the security group you want to revoke access from
security_group_id_to_revoke = 'sg-yy'

# Get the security group object
security_group = ec2.SecurityGroup(security_group_id_to_modify)

try:
    response = security_group.revoke_ingress(
        IpPermissions=[
            {
                'IpProtocol': '-1',  # -1 means all protocols
                'UserIdGroupPairs': [
                    {
                        'GroupId': security_group_id_to_revoke
                    }
                ]
            }
        ]
    )
    print(response)
except Exception as e:
    print(e)

