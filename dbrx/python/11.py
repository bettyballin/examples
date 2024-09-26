import html
from html.parser import HTMLParser

class TextExtractor(HTMLParser):
    def __init__(self):
        super().__init__()
        self.result = []

    def handle_data(self, data):
        self.result.append(data)

def strip_html_tags(html_string):
    """
    Remove all HTML tags leaving only text content.
    Entities are preserved.

    :param str html_string: The string containing the original HTML code.
    :return: A new string with no HTML tags and properly decoded entities.
    """

    # Create a parser instance
    parser = TextExtractor()

    # Parse the input as an HTML document converting it to plain text
    parser.feed(html.unescape(html_string))
    parser.close()

    return ''.join(parser.result)