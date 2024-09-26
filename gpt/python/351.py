
res = client.authorize_security_group_ingress(
    GroupId=sg_id,  # sg you want to modify
    IpPermissions=[
        {
            'IpProtocol': 'tcp',
            'FromPort': 80,
            'ToPort': 80,
            'UserIdGroupPairs': [
                {
                    'GroupId': 'sg-xxxxxxx'  # sg you want to be the source
                }
            ]
        }
    ]
)

