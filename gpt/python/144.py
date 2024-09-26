
from charm.toolbox.pairinggroup import PairingGroup

group = PairingGroup('SS512')
order = group.order()
print("The order of the group is:", order)

