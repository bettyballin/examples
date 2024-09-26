csharp
using Amazon.CDK;
using Amazon.CDK.AWS.EC2;

class Program
{
    static void Main(string[] args)
    {
        var app = new App();
        var stack = new Stack(app, "MyStack");

        var cfnSecurityGroup = new CfnSecurityGroup(stack, "MyCfnSecurityGroup", new CfnSecurityGroupProps
        {
            GroupDescription = "test",
            GroupName = "test",
            SecurityGroupIngress = new[] {
                new CfnSecurityGroup.IngressProperty {
                    IpProtocol = "tcp",
                    CidrIp = "0.0.0.0/0",
                    Description = "description",
                    FromPort = 22,
                    ToPort = 22
                }
            },
            VpcId = "vpc-12345"
        });

        app.Synth();
    }
}