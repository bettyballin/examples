import string

sh = int(input())
s = input()

# Create mapping dictionaries for uppercase letters and special characters
trans_dict_uppercase = str.maketrans(string.ascii_uppercase, string.ascii_uppercase[sh:] + string.ascii_uppercase[:sh])
trans_dict_special_chars = {ord('£'): '\\-62\\-93'}

n = s.translate(trans_dict_uppercase).translate(trans_dict_special_chars)

print(n)