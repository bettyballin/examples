
ALPHABET1 = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
key = "TES"

# Initialize ALPHABET2 with the key
ALPHABET2 = key

# Iterate over each character in the key
for char in key:
    # Remove the current character from ALPHABET1
    ALPHABET1 = ALPHABET1.replace(char, "")

# Append the modified ALPHABET1 to ALPHABET2
ALPHABET2 += ALPHABET1

print(ALPHABET2)

