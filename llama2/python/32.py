from django.utils.safestring import mark_safe
from django.db import models
import re

def url_filter(comment):
    url_regex = re.compile(r'(https?:\/\/[^\s]+)')
    return url_regex.sub(r'<a href="\1">\1</a>', comment)

class MyModel(models.Model):
    comment = models.TextField()

    def clean_comment(self):
        comment = self.comment
        filtered_comment = url_filter(comment)
        return mark_safe(filtered_comment)