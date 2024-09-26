from ftplib import FTP

ftp = FTP('garner.ucsd.edu')
ftp.login()
ftp.cwd('pub/products')