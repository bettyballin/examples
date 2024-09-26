import string

def apparitions(chain):
    chain = chain.upper()  # convert to upper case
    app = [0] * 26
    for c in chain :
        if c in string.ascii_uppercase :
            app[ord(c) - ord('A')] += 1
    return app

# Test the function
print(apparitions("Hello, World!"))