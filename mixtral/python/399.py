import ssl
from urllib import request

src = "https://ssl.server.tlb/path/to/file"
target = "/path/to/saved_file"

context = ssl._create_unverified_context()  # Disable SSL certificate verification

with open(target, 'wb') as out_file:
    with request.urlopen(src, context=context) as response:
        data = response.read()
        out_file.write(data)