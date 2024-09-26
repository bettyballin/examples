from django.core.exceptions import ValidationError
from django.core.validators import URLValidator

def validate_text(value):
    url_validator = URLValidator()

    try:
        # Try to parse the input as a single string
        url_validator(value)
        raise ValidationError("URLs are not allowed in the text.")
    except ValidationError:
        pass

# Example usage:
try:
    validate_text("http://example.com")
except ValidationError as e:
    print(e)