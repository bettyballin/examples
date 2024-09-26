import hashlib
from charm.toolbox.pairinggroup import PairingGroup, ZR, G1

def setup(secparam):
    group = PairingGroup('SS512', secparam)

    # Generate a random message
    msg_str = "Hello World!"

    # Hash the string to get bytes
    hash_obj = hashlib.sha384()
    hash_obj.update(msg_str.encode())

    # Convert hashed value into an integer
    m = int('0x' + hash_obj.hexdigest(), 16)

    return group, G1(m), ZR(secparam // 2)

groupObj, msg, order = setup(512)