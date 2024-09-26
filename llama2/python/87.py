import os
import urllib.request

class PdfDownloader:
    def __init__(self, options, pdfurl):
        self.options = options
        self.pdfurl = pdfurl

    def download_pdf(self):
        # Get absolute path for PDF file
        pdf_path = os.path.abspath(os.path.join(self.options.storefolder, self.options.uniquecode+".pdf"))

        # Save PDF file to secure location
        urllib.request.urlretrieve(self.pdfurl, pdf_path)

# Example usage:
class Options:
    def __init__(self, storefolder, uniquecode):
        self.storefolder = storefolder
        self.uniquecode = uniquecode

options = Options("/path/to/store/folder", "unique_code")
pdfurl = "https://example.com/path/to/pdf"

downloader = PdfDownloader(options, pdfurl)
downloader.download_pdf()