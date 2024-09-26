import bleach

def remove_html(input):
    return bleach.clean(input, tags=[], strip=True)

# Test the function
text = "Asia sp\u00e9cialiste du voyage <script>alert('xss')</script>"
print(remove_html(text))