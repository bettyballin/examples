import re
import html

def strip_html_tags(input_html):
    clean_text = re.sub('<.*?>', '', input_html)
    return html.unescape(clean_text)

input_html = '<p>Asia sp&eacute;cialiste du voyage</p>'
output_text = strip_html_tags(input_html)
print(output_text)  # Output: Asia spécialiste du voyage