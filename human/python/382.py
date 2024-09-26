s = 'This\x00string\x00is\x00an\x00\x07Example.'
s_list = [s]
print(s_list)  # List
print(set(s_list))  # Set
print(tuple(s_list))  # Tuple