import hashlib

string = "1"

complete = False
n = 0

while not complete:
    curr_string = string + str(n)
    curr_hash = hashlib.sha256(curr_string.encode()).hexdigest()

    n += 1

    if curr_hash.startswith('0' * 7):
        print("Hash:", curr_hash)
        print("String:", curr_string)

        complete = True