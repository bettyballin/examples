import re

simple_url_re = re.compile(r'^(https?)?://\[?\w', re.IGNORECASE)
simple_url_2_re = re.compile(r'^www\.|^(?!http)\w[^@]+\.(com|edu|gov|int|mil|net|org)$', re.IGNORECASE)

def validate_url(text):
    if simple_url_re.match(text) or simple_url_2_re.match(text):
        raise ValueError("Invalid URL")

# Test the function
text = input("Enter a URL: ")
try:
    validate_url(text)
except ValueError as e:
    print(e)
else:
    print("URL is valid")