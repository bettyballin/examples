import re

def validate_url(text):
    url_pattern = r'http[s]?://(?:[a-zA-Z]|[0-9]|[$-_@.&+]|[!*\\(\\]|(?:%[0-9a-fA-F][0-9a-fA-F]))+'
    urls_found = re.findall(url_pattern, text)
    
    if len(urls_found) > 0:
        return False
    else:
        return True

# Usage example
text_with_url = "blablabla http://bla.com"
if not validate_url(text_with_url):
    print("URL found in the comment. Submission denied.")
else:
    print("No URL detected. Comment submission allowed.")