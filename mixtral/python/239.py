import os
from cryptography import x509
from cryptography.hazmat.backends import default_backend

fname = 'path_to_your_file'  # replace with your file path
sigoff = 0  # replace with your signature offset
siglen = 1024  # replace with your signature length

with open(fname, 'rb') as fh:
    fh.seek(sigoff)
    thesig = fh.read(siglen)

# Load certificate without slicing
cert = x509.load_der_x509_certificate(thesig, default_backend())