
import re
from django.core.exceptions import ValidationError

def validate_no_urls(value):
    # Regex to find URLs - This is a basic example and might be adjusted to meet your needs
    url_pattern = re.compile(r'https?://(?:[-\w.]|(?:%[\da-fA-F]{2}))+|www\.\S+\.com')
    
    # Search for URLs within the text
    if url_pattern.search(value):
        raise ValidationError("Posting URLs is not allowed.")

# In your form or model
from django import forms

class CommentForm(forms.Form):
    comment = forms.CharField(validators=[validate_no_urls])

# or in a model:
from django.db import models

class Comment(models.Model):
    text = models.TextField(validators=[validate_no_urls])

