import hashlib

data = b'Hello, World!'
digest_size = 64
key = b'secret_key'
salt = b'salt_value'
person = b'person_name'
fanout = 1
depth = 1
leaf_size = 0
node_offset = 0
node_depth = 0
inner_size = 0
last_node = False

hash_object = hashlib.blake2b(
    data=data,
    digest_size=digest_size,
    key=key,
    salt=salt,
    person=person,
    fanout=fanout,
    depth=depth,
    leaf_size=leaf_size,
    node_offset=node_offset,
    node_depth=node_depth,
    inner_size=inner_size,
    last_node=last_node
)

print(hash_object.hexdigest())