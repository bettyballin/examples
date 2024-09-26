import cdktf_cdktf_provider_aws.security_group as SecurityGroup_

class Example:
    def __init__(self, scope_object, id, name, vpc_id):
        self.scope_object = scope_object
        self.id = id
        self.name = name
        self.vpc_id = vpc_id
        self.security_group_ = SecurityGroup_.SecurityGroup(
            self.scope_object,
            id_=self.id,
            name=self.name,
            vpc_id=self.vpc_id,
            ingress=[{"from_port": 3306, "to_port": 3306}]
        )

# usage
example = Example("scope", "id", "name", "vpc_id")