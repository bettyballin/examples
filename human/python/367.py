import pefile
from cryptography import x509
from cryptography.hazmat.backends import default_backend
from asn1crypto import cms

def parse_signature(fname):
    pe = pefile.PE(fname)
    sigoff = pe.OPTIONAL_HEADER.DATA_DIRECTORY[pefile.DIRECTORY_ENTRY["IMAGE_DIRECTORY_ENTRY_SECURITY"]].VirtualAddress
    siglen = pe.OPTIONAL_HEADER.DATA_DIRECTORY[pefile.DIRECTORY_ENTRY["IMAGE_DIRECTORY_ENTRY_SECURITY"]].Size
    pe.close()

    with open(fname, 'rb') as fh:
        fh.seek(sigoff)
        thesig = fh.read(siglen)

    signature = cms.ContentInfo.load(thesig[8:])

    for cert in signature["content"]["certificates"]:
        parsed_cert = x509.load_der_x509_certificate(cert.dump(), default_backend())
        print(parsed_cert)

if __name__ == "__main__":
    fname = "path_to_your_file.exe"  # replace with your file path
    parse_signature(fname)