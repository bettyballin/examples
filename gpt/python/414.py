
from Crypto.Hash import SHA256

# ... (other constants remain unchanged)

def compute_gen():
    k = (P - 1) // Q
    for count in range(1, 0xffff):
        U = domain_parameter_seed + ggen + index + count.to_bytes(2, 'big')
       
