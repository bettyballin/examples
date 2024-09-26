import pefile
from cryptography.hazmat.primitives import serialization
from cryptography.hazmat.backends import default_backend
from cryptography import x509

fname = 'path_to_your_file.exe'  # replace with your file path

pe = pefile.PE(fname)
pe.parse_data_directories(directories=[pefile.DIRECTORY_ENTRY['IMAGE_DIRECTORY_ENTRY_SECURITY']])
sigoff = 0
siglen = 0
for s in pe.__structures__:
    if s.name == 'IMAGE_DIRECTORY_ENTRY_SECURITY':
        sigoff = s.VirtualAddress
        siglen = s.Size

with open(fname, 'rb') as fh:
    fh.seek(sigoff)
    thesig = serialization.load_der_pkcs7_cms(fh.read(siglen), default_backend())

certs = [c for c in thesig.certificates if isinstance(c, x509.Certificate)]
if certs:
    cert = certs[0]
else:
    raise ValueError("No certificate found")