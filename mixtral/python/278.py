s = "Men of few words are the best men."
octets = s.encode('utf-8')
print(type(octets))  # <class 'bytes'>
print(list(octets))
# Output will be a list containing octet values for each character in string