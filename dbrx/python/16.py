from django.core.exceptions import ValidationError
from django.core.validators import URLValidator

def validate_url(text):
    url_validator = URLValidator()
    
    try:
        for word in text.split():
            if 'http' not in word and '.' not in word:  # Skip words without a dot or http(s)
                continue
            
            url_validator(word)  # Validate the current "word"
        
        return True
    except ValidationError:
        return False

# Usage example
text_with_url = "blablabla http://bla.com"
if validate_url(text_with_url):
    print("No URL detected. Comment submission allowed.")
else:
    print("URL found in the comment. Submission denied.")