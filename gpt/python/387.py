
# proof-of-work.py
import hashlib

string = "1"

complete = False
n = 0

while not complete:
    curr_string = string + str(n)
    # Use hashlib to compute the SHA-256 hash
    curr_hash = hashlib.sha256(curr_string.encode('utf-8')).hexdigest()
    n += 1

    # slows performance drastically
    ## print(curr_hash)

    if curr_hash.startswith('000000'):
        print(curr_hash)
        print(curr_string)
        complete = True

