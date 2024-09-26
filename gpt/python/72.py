
from lxml import etree
from io import StringIO
import html

def remove_html_tags(text):
    # Parse the HTML
    parser = etree.HTMLParser()
    tree = etree.parse(StringIO(text), parser)
    
    # Extract text without tags (it handles entities automatically)
    text_without_tags = etree.tostring(tree.getroot(), encoding='unicode', method='text')
    
    # Convert HTML entities to their corresponding characters
    unescaped_text = html.unescape(text_without_tags)
    
    return unescaped_text

input_string = u"<html><body><p>Asia, sp&eacute;cialiste du voyage...</p></body></html>"
clean_text = remove_html_tags(input_string)
print(clean_text)

