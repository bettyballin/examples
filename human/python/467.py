class UserIdGroupPair:
    def __init__(self, Description, GroupId, GroupName=None, PeeringStatus=None, UserId=None, VpcId=None, VpcPeeringConnectionId=None):
        self.Description = Description
        self.GroupId = GroupId
        self.GroupName = GroupName
        self.PeeringStatus = PeeringStatus
        self.UserId = UserId
        self.VpcId = VpcId
        self.VpcPeeringConnectionId = VpcPeeringConnectionId

class UserIdGroupPairs:
    def __init__(self):
        self.UserIdGroupPairList = []

    def add(self, pair):
        if isinstance(pair, UserIdGroupPair):
            self.UserIdGroupPairList.append(pair)
        else:
            raise TypeError("Only UserIdGroupPair instances can be added")

    def to_dict(self):
        return [pair.__dict__ for pair in self.UserIdGroupPairList]

# Example usage
pairs = UserIdGroupPairs()
pair1 = UserIdGroupPair("Test Description", "sg-12345678", GroupName="test-group", UserId="123456789012")
pair2 = UserIdGroupPair("Another Description", "sg-90123456", VpcId="vpc-12345678")
pairs.add(pair1)
pairs.add(pair2)
print(pairs.to_dict())