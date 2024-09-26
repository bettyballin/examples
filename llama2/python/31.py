import re
from django.utils.safestring import mark_safe

def url_filter(text):
    url_regex = r"http\S+"
    return mark_safe(re.sub(url_regex, "", text))