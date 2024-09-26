res = client.authorize_security_group_ingress(
    GroupId=sg_1_id,
    IpPermissions=[
        {
            'IpProtocol': 'tcp',
            'FromPort': 80,
            'ToPort': 80,
            'UserIdGroupPairs': [
                {
                    'GroupId': sg_2_id
                }
            ]
        }
    ]
)