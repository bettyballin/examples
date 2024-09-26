self.security_group_ = SecurityGroup_.SecurityGroup(
    self.scope_object, 
    id_=self.id, 
    name=self.name, 
    vpc_id=self.vpc_id, 
    ingress=[SecurityGroup_.SecurityGroupIngress(from_port=3306,to_port=3306, security_groups=['test-sg'])])