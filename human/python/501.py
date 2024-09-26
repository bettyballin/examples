def bin_string_to_int(s):
   breakdown = [int(d)*2**n for n,d in enumerate(reversed(s))]
   return sum(breakdown)

b1 = "101" 
b1_in_int = bin_string_to_int(b1)

b2 = "10" 
b2_in_int = bin_string_to_int(b2)

print(b1_in_int % b2_in_int)