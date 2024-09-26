import lxml.etree as ET

def strip_html(html):
    root = ET.fromstring(html)
    return ''.join([text for text in root.itertext()])

if __name__ == "__main__":
    html = input("Enter HTML: ")
    print(strip_html(html))