import cdktf_cdktf_provider_aws.security_group as SecurityGroup_

class SecurityGroup:
    def __init__(self, scope, id, name, vpc_id):
        self.scope = scope
        self.id = id
        self.name = name
        self.vpc_id = vpc_id
        self.security_group_ = SecurityGroup_.SecurityGroup(
            self.scope, 
            id_=self.id, 
            name=self.name, 
            vpc_id=self.vpc_id, 
            ingress=[{"to_port": 3306}]
        )

# usage
scope = "your_scope"
id = "your_id"
name = "your_name"
vpc_id = "your_vpc_id"

security_group = SecurityGroup(scope, id, name, vpc_id)