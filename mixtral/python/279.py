s = "Men of few words are the best men."
octets = s.encode('utf-8')
back_to_string = octets.decode('utf-8')
print(type(back_to_string))  # <class 'str'>
assert back_to_string == s