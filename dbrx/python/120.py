import urllib.parse
import os
import string

def download_pdf(pdfurl, options):
    # Validate url format (optional)
    parsed_url = urllib.parse.urlparse(pdfurl)
    if not parsed_url.scheme or not parsed_url.netloc:
        raise ValueError("Invalid URL")

    # Extract file name from url and validate characters
    file_name = os.path.basename(parsed_url.path)
    valid_chars = "-_.() %s%s" % (string.ascii_letters, string.digits)
    invalid_char_found = False

    for char in file_name:
        if char not in valid_chars:
            invalid_char_found = True
            break

    if invalid_char_found or ".." in file_name or file_name.startswith("."):
        raise ValueError("Invalid file name")

    pdf_destination = os.path.join(options.storefolder, options.uniquecode + "_" + file_name)
    import urllib.request
    urllib.request.urlretrieve(pdfurl, pdf_destination)

# example usage:
class Options:
    def __init__(self):
        self.storefolder = "/path/to/store/folder"
        self.uniquecode = "unique_code"

options = Options()
pdfurl = "http://example.com/path/to/file.pdf"
download_pdf(pdfurl, options)