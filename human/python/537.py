from hashlib import sha256

string = "1"

complete = False
n = 0

while not complete:
    curr_string = string + str(n)
    curr_hash = sha256(curr_string.encode()).hexdigest()
    n += 1
    
    print(curr_hash + ' ' + curr_hash[:4])