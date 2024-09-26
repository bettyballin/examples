import hashlib

hash_object = hashlib.sha1(b'asdf')
print(hash_object.hexdigest())