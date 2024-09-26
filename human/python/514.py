from pylfsr import LFSR

# The initial state
state = [0,0,0,1,0,1,0,1,0,1,1]
# The LFSR polynomial use a primitive polynomail to get maximum period length
poly = [5, 4, 3, 2]
l = LFSR(fpoly=poly, initstate=state)

message = b"This is a Test Message"
ciphertext = b""

# generate all LFSR sequence
allseq = l.runFullCycle()
seq = ""
seq_index = 0

# Convert LFSR bits into a string
for x in allseq:
    seq += str(x)

for counter in range(len(message)):
    ran_seq = seq[seq_index: seq_index+8]
    # Now encrypt by XOR convert to bytes and append to ciphertext
    ciphertext += bytes([message[counter] ^ int(ran_seq, 2)])
    seq_index += 8  # Move sequence to Next byte

print(ciphertext)

plaintext = b""
# Reset The LFSR sequence to start from beginning
seq_index = 0
for counter in range(len(ciphertext)):
    ran_seq = seq[seq_index: seq_index+8]
    plaintext += bytes([ciphertext[counter] ^ int(ran_seq, 2)])
    seq_index += 8

print(plaintext)