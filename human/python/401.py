# let b is your bytes
b = b'\xe4\x06-\x95\xf5!P4'

# first convert it to hex
bHex = b.hex()

# convert it to integer
bInt = int(bHex, 16)

# finally convert it to binary and remove '0b' prefix
bBin = bin(bInt)[2:].zfill(8 * len(b))

print(bBin)