domain_parameter_seed = b'some_domain_parameter_seed'
ggen = b'some_ggen'
index = b'some_index'
count = 123

U = bytes.fromhex((domain_parameter_seed + ggen + index).hex()) + count.to_bytes(2, 'big')
print(U)