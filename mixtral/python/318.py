res = client.authorize_security_group_ingress(
    GroupId=sg_id,
    IpPermissions=[{
        'FromPort': 80,
        'ToPort': 80,
        'IpProtocol': 'tcp',
        'UserIdGroupPairs': [{
            'VpcId': '<your-vpc-id>',
            'GroupName': '<source_sg_name>'
         }]
    }]
)