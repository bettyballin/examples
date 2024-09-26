
import cdktf_cdktf_provider_aws.security_group as SecurityGroup_

self.security_group_ = SecurityGroup_.SecurityGroup(
    self.scope_object,
    id_=self.id,
    name=self.name,
    vpc_id=self.vpc_id,
    ingress=[{
        "from_port": 3306,  # from_port should be an integer
        "to_port": 3306,    # to_port should be an integer
        "protocol": "tcp",
        "cidr_blocks": ["0.0.0.0/0"]  # or specify your specific CIDR range
        # Optionally add other fields like "description", "ipv6_cidr_blocks", etc.
    }]
)

