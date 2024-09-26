
from OpenSSL import crypto

# Load the .p12 file
p12_filename = 'your_certificate.p12'
p12_password = b'your_password'  # Password as bytes

with open(p12_filename, 'rb') as f:
    p12_data = f.read()

# Load the PKCS#12 object
p12 = crypto.load_pkcs12(p12_data, p12_password)

# Extract the certificate from the PKCS#12 object
cert = p12.get_certificate()

# Extract the subject from the certificate
subject = cert.get_subject()

# Extract the first and last name (commonly part of the CN field)
cn = subject.CN

# Assuming the CN is in the format "LASTNAME, FIRSTNAME" (check your cert format)
names = cn.split(', ')
first_name = names[1] if
