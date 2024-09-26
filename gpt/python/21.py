
import hashlib

def sha256_from_file(fileName, block_size=2**14):
    sha256 = hashlib.sha256()
    with open(fileName, 'rb') as f:  # Open the file in binary mode
        for block in iter(lambda: f.read(block_size), b''):
            sha256.update(block)
    return sha256.hexdigest()

