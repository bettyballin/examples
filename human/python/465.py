import boto3

security_group_source = boto3.client('ec2')

group_id_source = 'sg-12345678'
FromPort = 22
IpProtocol = 'tcp'
ToPort = 22
group_id_target = 'sg-87654321'
VpcId_target = 'vpc-12345678'

response = security_group_source.revoke_ingress(
    GroupId=group_id_source,
    IpPermissions=[
        {'FromPort': FromPort,
         'IpProtocol': IpProtocol,
         'ToPort': ToPort,
         'UserIdGroupPairs': [
             {
                 'GroupId': group_id_target,
                 'VpcId': VpcId_target,
             },
         ]
         },
    ],
    DryRun=False
)

print(response)