from lxml import html as lhtml

def strip_html_tags_lxml(html_string):
    """
    Remove all HTML tags leaving only text content.
    Entities are preserved.

    :param str html_string: The string containing the original HTML code.
    :return: A new string with no HTML tags and properly decoded entities.
    """

    cleaner = lhtml.clean.Cleaner(remove_tags=['*'])
    return cleaner.clean_html(html_string)