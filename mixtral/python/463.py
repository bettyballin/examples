import cdktf_cdktf_provider_aws as aws

class MyStack:
    def __init__(self, scope):
        self.scope = scope
        self.id = "my-sg"
        self.security_group = aws.SecurityGroup(
            self.scope,
            id=self.id,
            name="my-sg",
            vpc_id="your-vpc-id",
            ingress=[
                {
                    "from_port": 3306,
                    "to_port": 3306,
                    "protocol": "tcp"
                }
            ]
        )

app = aws.CdktfApp()
stack = MyStack(app)
app.synth()