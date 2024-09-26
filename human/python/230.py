counter_iv = 112  # Can be from 0 to 3.40e38
temp = []  # Will be an array of bytes
for i in range(16):
    # Get the i'th byte counting from the least significant end
    b = (counter_iv >> (i * 8)) & 0xFF
    temp.append(b)

# Will be an array of 1-character strings
temp2 = [chr(b) for b in temp]

# Concatenate all the above together
iv_bytes = "".join(temp2)
print(iv_bytes)