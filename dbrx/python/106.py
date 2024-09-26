import base64

def ord_(string):
    return string.encode().decode('unicode_escape')

def chr_(code):
    if code < 0 or code > 65535: raise ValueError("Invalid Unicode code point!")
    return chr(code)

# test the functions
print(ord_("\\x61"))
print(chr_(97))