
import pefile
from cryptography import x509
from cryptography.hazmat.backends import default_backend
from asn1crypto import cms

pe = pefile.PE(fname)
pe.parse_data_directories(directories=[pefile.DIRECTORY_ENTRY['IMAGE_DIRECTORY_ENTRY_SECURITY']])
sigoff = 0
siglen = 0
for s in pe.__structures__:
    if s.name == 'IMAGE_DIRECTORY_ENTRY_SECURITY':
        sigoff = s.VirtualAddress
        siglen
