
from ftplib import FTP

ftp = FTP('garner.ucsd.edu')
ftp.login()  # This defaults to anonymous login
ftp.cwd('pub/products')

# Do your operations here...

ftp.quit()

