import string

key = "example_key"
alpha = [c for c in string.ascii_uppercase if c not in key]
alpha.extend(set(key))
print(alpha)