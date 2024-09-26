import re
from django.core.exceptions import ValidationError  # assuming Django, otherwise define your own ValidationError

def validate_text(value):
    url_pattern = re.compile('http[s]?://(?:[a-zA-Z]|[0-9]|[$-_@.&+]|[!*\\\\(\\\\]|(?:%[0-9a-fA-F][0-9a-fA-F]))+')
    if url_pattern.search(value):
        raise ValidationError("URLs are not allowed in the text.")

# example usage:
try:
    validate_text("Hello, world!")
    validate_text("Hello, http://example.com!")
except ValidationError as e:
    print(e)