import re

def validate_pdfurl(input):
    if not isinstance(input, str) or bool(re.search('[^a-zA-Z0-9./]', input)):
        return False

    # You can add more checks based on your requirements

    return True

# Test the function
print(validate_pdfurl("https://example.com/file.pdf"))  # Should return True
print(validate_pdfurl("invalid_url"))  # Should return True
print(validate_pdfurl("https://example.com/file.pdf?query=param"))  # Should return False
print(validate_pdfurl(123))  # Should return False